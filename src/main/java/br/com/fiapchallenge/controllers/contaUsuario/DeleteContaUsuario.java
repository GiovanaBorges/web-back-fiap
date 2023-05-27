package br.com.fiapchallenge.controllers.contaUsuario;

import br.com.fiapchallenge.dao.ContaUsuario.ContaUsuarioDAO;
import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteContaUsuario {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        ContaUsuarioDAO dao = new ContaUsuarioDAO(connection);
        dao.delete(1L);

        connection.close();
    }
}
