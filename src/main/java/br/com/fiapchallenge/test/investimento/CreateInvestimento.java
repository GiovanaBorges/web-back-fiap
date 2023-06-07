package br.com.fiapchallenge.test.investimento;

import br.com.fiapchallenge.dao.despesaDAO.DespesaDAO;
import br.com.fiapchallenge.dao.investimento.InvestimentoDAO;
import br.com.fiapchallenge.infra.ConnDB;
import br.com.fiapchallenge.model.Investimento;


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreateInvestimento {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnDB.getConnection();

        Investimento investimento = new Investimento(350.56, Date.valueOf(LocalDate.of(2021, 5, 10)),Date.valueOf(LocalDate.of(2021, 5, 10)), "Compra do mês","Compra desse mes",1);

        InvestimentoDAO dao = new InvestimentoDAO(connection);
        dao.save(investimento);
        connection.close();
    }
}
