package br.com.fiapchallenge.controllers.contaUsuario;

import br.com.fiapchallenge.dao.ContaUsuario.ContaUsuarioDAO;
import br.com.fiapchallenge.dao.UsuarioDAO.UsuarioDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.ContaUsuario;
import br.com.fiapchallenge.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateContaUsuario {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        ContaUsuario contausuario = new ContaUsuario(55,"0123","bancoBrasil","usuarioTeste");

        ContaUsuarioDAO dao = new ContaUsuarioDAO(connection);
        dao.save(contausuario);
        connection.close();
    }
}
