package br.com.fiapchallenge.controllers.Usuario;

import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.dao.UsuarioDAO.UsuarioDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteUsuario {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        UsuarioDAO dao = new UsuarioDAO(connection);
        dao.delete(1L);

        connection.close();
    }
}
