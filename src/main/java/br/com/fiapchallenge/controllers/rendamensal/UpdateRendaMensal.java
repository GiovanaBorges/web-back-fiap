package br.com.fiapchallenge.controllers.rendamensal;

import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.RendaMensal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UpdateRendaMensal {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        RendaMensalDAO dao = new RendaMensalDAO(connection);
        Optional<RendaMensal> optional = dao.findById(2L);

        optional.ifPresent(it -> {
            it.setRenda("Descrição atualizada");
            it.setRendaMensal(46.98);
            dao.update(it);
        });

        connection.close();
    }
}
