package br.com.fiapchallenge.controllers.contaUsuario;

import br.com.fiapchallenge.dao.ContaUsuario.ContaUsuarioDAO;
import br.com.fiapchallenge.infra.ConnectionFactory;
import br.com.fiapchallenge.model.ContaUsuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ListAllContaUsuario {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        ContaUsuarioDAO dao = new ContaUsuarioDAO(connection);
        List<ContaUsuario> contas = dao.findAll();

        for (ContaUsuario conta : contas) {

            System.out.println("ID => " + conta.getId());
            System.out.println("Numero => " + conta.getNumero());
            System.out.println("Usuario => " + conta.getUsuario());
            System.out.println("Agencia => " + conta.getAgencia());
            System.out.println("Banco => " + conta.getBanco());
            System.out.println("---------------");
        }

        connection.close();
    }
}
