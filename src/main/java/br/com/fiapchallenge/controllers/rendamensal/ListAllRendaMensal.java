package br.com.fiapchallenge.controllers.rendamensal;

import br.com.fiapchallenge.dao.RendaMensalDAO.RendaMensalDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.RendaMensal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListAllRendaMensal {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        RendaMensalDAO dao = new RendaMensalDAO(connection);
        List<RendaMensal> rendas = dao.findAll();

        for (RendaMensal renda : rendas) {

            System.out.println("ID => " + renda.getId());
            System.out.println("Data => " + renda.getData());
            System.out.println("Descricao => " + renda.getRenda());
            System.out.println("Valor => " + renda.getRendaMensal());
            System.out.println("Usuario => " + renda.getUsuario());
            System.out.println("Numero conta => " + renda.getConta());
            System.out.println("---------------");
        }

        connection.close();
    }
}
