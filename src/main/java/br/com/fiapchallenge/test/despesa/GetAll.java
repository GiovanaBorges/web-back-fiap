package br.com.fiapchallenge.test.despesa;

import br.com.fiapchallenge.dao.despesaDAO.DespesaDAO;
import br.com.fiapchallenge.infra.ConnDB;
import br.com.fiapchallenge.model.Despesa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GetAll {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnDB.getConnection();

        DespesaDAO dao = new DespesaDAO(connection);
        List<Despesa> despesas = dao.findAll();

        for (Despesa despesa : despesas) {

            System.out.println("ID => " + despesa.getId());
            System.out.println("Data => " + despesa.getDt_despesa());
            System.out.println("Tipo despesa => " + despesa.getTipo_despesa());
            System.out.println("Valor => " + despesa.getValor_despesa());
            System.out.println("Usuario => " + despesa.getId_usuario());
            System.out.println("---------------");
        }

        connection.close();
    }
}
