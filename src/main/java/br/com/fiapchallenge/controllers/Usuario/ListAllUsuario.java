package br.com.fiapchallenge.controllers.Usuario;

import br.com.fiapchallenge.dao.UsuarioDAO.UsuarioDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.RendaMensal;
import br.com.fiapchallenge.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListAllUsuario {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        UsuarioDAO dao = new UsuarioDAO(connection);
        List<Usuario> usuarios = dao.findAll();

        for (Usuario usuario : usuarios) {

            System.out.println("ID => " + usuario.getId());
            System.out.println("Usuario => " + usuario.getUsuario());
            System.out.println("Senha => " + usuario.getSenha());
            System.out.println("---------------");
        }

        connection.close();
    }
}
