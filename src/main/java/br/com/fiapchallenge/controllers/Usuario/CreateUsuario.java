package br.com.fiapchallenge.controllers.Usuario;

import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.dao.UsuarioDAO.UsuarioDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.RendaMensal;
import br.com.fiapchallenge.model.Usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreateUsuario {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        Usuario usuario = new Usuario("usuarioTeste","12345senhadificil");

        UsuarioDAO dao = new UsuarioDAO(connection);
        dao.save(usuario);
        connection.close();
    }
}
