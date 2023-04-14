package com.github.anderson.vendas.domain.repository;

import com.github.anderson.vendas.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository {

    private final String INSERT = "insert into cliente (nome) values (?)";
    private final String SELECT_ALL = "select * from cliente";
    private final String UPDATE = "update cliente set nome = ? where id = ?";
    private final String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente(id, nome);
            }
        });
    }

    public void atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, cliente.getNome(), cliente.getId());
    }

    public void deletar(Cliente cliente) {
        jdbcTemplate.update(DELETE, cliente.getId());
    }

    public void deletar(Integer id) {
        jdbcTemplate.update(DELETE, id);
        System.out.println("Cliente deletado com sucesso: " + id);
    }

    public List<Cliente> obterPorNome(String nome) {
        return jdbcTemplate.query(SELECT_ALL.concat(" where nome like ? "), new Object[]{"%" + nome + "%"}, (resultSet, i) -> {
            Integer id = resultSet.getInt("id");
            String nome1 = resultSet.getString("nome");
            return new Cliente(id, nome1);
        });
    }
}
