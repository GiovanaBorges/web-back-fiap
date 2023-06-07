package br.com.fiapchallenge.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnDB {

    private ConnDB(){}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/TesteFiapDB", "root", "123");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
