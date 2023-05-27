package br.com.fiapchallenge.controllers.Usuario;

import br.com.fiapchallenge.dao.UsuarioDAO.UsuarioDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.RendaMensal;
import br.com.fiapchallenge.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UpdateUsuario {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        UsuarioDAO dao = new UsuarioDAO(connection);
        Optional<Usuario> optional = dao.findById(2L);

        optional.ifPresent(it -> {
            it.setUsuario("newNameUser");
            it.setSenha("senhanovadificil");
            dao.update(it);
        });

        connection.close();
    }
}
