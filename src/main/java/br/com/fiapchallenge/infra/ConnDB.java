package br.com.fiapchallenge.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDB {

    public static void main(String... x) {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/testedb?user=root&password=1234");

            System.out.println("Conectado");

            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}