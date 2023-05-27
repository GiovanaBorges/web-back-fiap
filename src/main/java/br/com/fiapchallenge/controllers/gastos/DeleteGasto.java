package br.com.fiapchallenge.controllers.gastos;

import br.com.fiapchallenge.dao.GastosDAO.GastosDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteGasto {
    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.getConnection();
        GastosDAO dao = new GastosDAO(connection);
        dao.delete(1L);

        connection.close();
    }
}
