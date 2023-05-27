package br.com.fiapchallenge.controllers.gastos;

import br.com.fiapchallenge.dao.GastosDAO.GastosDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.Gastos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreateGastos {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        Gastos gastos = new Gastos(Date.valueOf(LocalDate.of(2021, 5, 10)),"Compra do mes",1,1,350.56);

        GastosDAO dao = new GastosDAO(connection);
        dao.save(gastos);
        connection.close();
    }
}
