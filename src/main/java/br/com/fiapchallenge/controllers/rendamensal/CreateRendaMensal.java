package br.com.fiapchallenge.controllers.rendamensal;

import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.RendaMensal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreateRendaMensal {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        RendaMensal renda = new RendaMensal(
            22.90,Date.valueOf(LocalDate.of(2021, 5, 10)),"comida",1,1
        );

        RendaMensalDAO dao = new RendaMensalDAO(connection);
        dao.save(renda);
        connection.close();
    }
}
