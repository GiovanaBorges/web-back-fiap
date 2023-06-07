package br.com.fiapchallenge.test.despesa;

import br.com.fiapchallenge.dao.despesaDAO.DespesaDAO;
import br.com.fiapchallenge.infra.ConnDB;
import br.com.fiapchallenge.model.Despesa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreateDespesa {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnDB.getConnection();

        Despesa despesa = new Despesa(350.56, Date.valueOf(LocalDate.of(2021, 5, 10)), "Compra do mês",1);

        DespesaDAO dao = new DespesaDAO(connection);
        dao.save(despesa);
        connection.close();
    }
}
