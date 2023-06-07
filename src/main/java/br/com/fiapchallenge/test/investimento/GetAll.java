package br.com.fiapchallenge.test.investimento;

import br.com.fiapchallenge.dao.despesaDAO.DespesaDAO;
import br.com.fiapchallenge.dao.investimento.InvestimentoDAO;
import br.com.fiapchallenge.infra.ConnDB;
import br.com.fiapchallenge.model.Despesa;
import br.com.fiapchallenge.model.Investimento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GetAll {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnDB.getConnection();

        InvestimentoDAO dao = new InvestimentoDAO(connection);
        List<Investimento> investimentos = dao.findAll();

        for (Investimento investimento : investimentos) {

            System.out.println("ID => " + investimento.getId());
            System.out.println("Data Inicial => " + investimento.getData_inicial());
            System.out.println("Data Final => " + investimento.getData_final());
            System.out.println("Nome investimento => " + investimento.getNm_investimento());
            System.out.println("Descricao investimento => " + investimento.getDescri_investimento());
            System.out.println("Valor => " + investimento.getVl_investimento());
            System.out.println("Usuario => " + investimento.getUsuario());
            System.out.println("---------------");
        }

        connection.close();
    }
}
