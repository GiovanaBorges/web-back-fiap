package br.com.fiapchallenge.controllers.rendamensal;

import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteRendaMensal {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        RendaMensalDAO dao = new RendaMensalDAO(connection);
        dao.delete(1L);

        connection.close();
    }
}
