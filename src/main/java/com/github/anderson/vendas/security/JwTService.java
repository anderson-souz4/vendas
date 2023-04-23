package com.github.anderson.vendas.security;

import com.github.anderson.vendas.VendasApplication;
import com.github.anderson.vendas.domain.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwTService {
    @Value("${security.jwt.expiracao}")
    private String expiracao;
    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String gerarToken(Usuario usuario) {
        long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString); // Pego a data e hora atual e adiciono o tempo de expiração
        Date data = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant()); // Converto para Date
        return Jwts.builder()
                .setSubject(usuario.getLogin()) // Seto o login do usuário
                .setExpiration(data) // Seto a data de expiração
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura) // Assino o token com a chave de assinatura
                .compact(); // Compacto o token
    }

    private Claims obterClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(chaveAssinatura)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenValido(String token) {
        try {
            Claims claims = obterClaims(token);
            Date dataExpiracao = claims.getExpiration();
            LocalDateTime data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        } catch (Exception e) {
            return false;
        }
    }


    public String obterLoginUsuario(String token) throws ExpiredJwtException {
        return (String) obterClaims(token).getSubject(); // Pego o login do usuário
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = new SpringApplication(VendasApplication.class).run(args);
        JwTService jwTService = contexto.getBean(JwTService.class);
        String token = jwTService.gerarToken(new Usuario().builder().login("anderson").build());
        System.out.println(token);

        boolean isTokenValido = jwTService.tokenValido(token);
        System.out.println("Token válido: " + isTokenValido);

        String login = jwTService.obterLoginUsuario(token);
        System.out.println("Login: " + login);
    }
}
