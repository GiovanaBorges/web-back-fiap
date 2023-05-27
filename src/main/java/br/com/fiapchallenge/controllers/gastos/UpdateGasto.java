package br.com.fiapchallenge.controllers.gastos;

import br.com.fiapchallenge.dao.GastosDAO.GastosDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.Gastos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UpdateGasto {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        GastosDAO dao = new GastosDAO(connection);
        Optional<Gastos> optional = dao.findById(2L);

        optional.ifPresent(it -> {
            it.setGastos("Descrição atualizada");
            it.setValor(46.98);
            dao.update(it);
        });

        connection.close();
    }
}
