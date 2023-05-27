package br.com.fiapchallenge.controllers.contaUsuario;

import br.com.fiapchallenge.dao.ContaUsuario.ContaUsuarioDAO;
import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.ContaUsuario;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UpdateContaUsuario {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        ContaUsuarioDAO dao = new ContaUsuarioDAO(connection);
        Optional<ContaUsuario> optional = dao.findById(2L);

        optional.ifPresent(it -> {
            it.setBanco("Nubank");
            it.setAgencia("8321");
            dao.update(it);
        });

        connection.close();
    }
}
