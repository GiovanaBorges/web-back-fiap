package br.com.fiapchallenge.controllers.gastos;

import br.com.fiapchallenge.dao.GastosDAO.GastosDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.Gastos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListAllGastos {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        GastosDAO dao = new GastosDAO(connection);
        List<Gastos> gastos = dao.findAll();

        for (Gastos gasto : gastos) {

            System.out.println("ID => " + gasto.getId());
            System.out.println("Data => " + gasto.getData());
            System.out.println("Descricao => " + gasto.getGastos());
            System.out.println("Valor => " + gasto.getValor());
            System.out.println("Usuario => " + gasto.getUsuario());
            System.out.println("Numero conta => " + gasto.getConta());
            System.out.println("---------------");
        }

        connection.close();
    }
}
