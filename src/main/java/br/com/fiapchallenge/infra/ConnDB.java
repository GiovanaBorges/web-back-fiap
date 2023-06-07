package br.com.fiapchallenge.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnDB {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testedb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";

    public static void main(String[] args) {

        System.out.println("Conectado");

        //INSERTS

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

            insertIntoTGastos(conn, "Expense description", "2023-06-01", 1, 100.50, 123);
            insertIntoTUsuario(conn, "Arthur", "password1");
            insertIntoTRendaMensal(conn, "Monthly income", "2023-06-01", 5000.00, 1, 123);
            insertIntoTContaUsuario(conn, 123, "123456789", "Nubank", "JohnDoe");
            insertIntoTDespesa(conn, 100.00, "2023-06-01", 1);
            insertIntoTInvestimento(conn, "Investment Name", "Investment Description", "2023-06-01", "2024-06-01", 1000.00, 1);

            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertIntoTGastos(Connection conn, String dscGastos, String dtGastos, int idUsuario, double vlGastos, int nrConta) throws SQLException {
        String sql = "INSERT INTO t_gastos (dsc_gastos, dt_gastos, id_usuario, vl_gastos, nr_conta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dscGastos);
            stmt.setString(2, dtGastos);
            stmt.setInt(3, idUsuario);
            stmt.setDouble(4, vlGastos);
            stmt.setInt(5, nrConta);
            stmt.executeUpdate();
        }
    }

    private static void insertIntoTUsuario(Connection conn, String usuario, String senha) throws SQLException {
        String sql = "INSERT INTO t_usuario (usuario, senha) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.executeUpdate();
        }
    }

    private static void insertIntoTRendaMensal(Connection conn, String dscRenda, String data, double valor, int idUsuario, int idConta) throws SQLException {
        String sql = "INSERT INTO t_rendamensal (dsc_renda, data, valor, id_usuario, id_conta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dscRenda);
            stmt.setString(2, data);
            stmt.setDouble(3, valor);
            stmt.setInt(4, idUsuario);
            stmt.setInt(5, idConta);
            stmt.executeUpdate();
        }
    }

    private static void insertIntoTContaUsuario(Connection conn, int nr, String agencia, String banco, String usuario) throws SQLException {
        String sql = "INSERT INTO t_contaUsuario (nr, agencia, banco, usuario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nr);
            stmt.setString(2, agencia);
            stmt.setString(3, banco);
            stmt.setString(4, usuario);
            stmt.executeUpdate();
        }
    }

    private static void insertIntoTDespesa(Connection conn, double vlDespesa, String dtDespesa, int idUsuario) throws SQLException {
        String sql = "INSERT INTO t_despesa (vl_despesa, dt_despesa, id_usuario) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, vlDespesa);
            stmt.setString(2, dtDespesa);
            stmt.setInt(3, idUsuario);
            stmt.executeUpdate();
        }
    }

    private static void insertIntoTInvestimento(Connection conn, String nmInvestimento, String dsInvestimento, String dtInicial, String dtFinal, double vlInvestimento, int idUsuario) throws SQLException {
        String sql = "INSERT INTO t_investimento (nm_investimento, ds_investimento, dt_inicial, dt_final, vl_investimento, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nmInvestimento);
            stmt.setString(2, dsInvestimento);
            stmt.setString(3, dtInicial);
            stmt.setString(4, dtFinal);
            stmt.setDouble(5, vlInvestimento);
            stmt.setInt(6, idUsuario);
            stmt.executeUpdate();
        }
    }
}
