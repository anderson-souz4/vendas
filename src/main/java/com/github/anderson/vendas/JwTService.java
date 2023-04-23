package com.github.anderson.vendas;

import com.github.anderson.vendas.domain.entity.Usuario;
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
}
