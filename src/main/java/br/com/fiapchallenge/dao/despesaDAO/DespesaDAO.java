package br.com.fiapchallenge.dao.despesaDAO;

import br.com.fiapchallenge.model.Despesa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DespesaDAO implements IDespesa{

    private final Connection connection;

    public DespesaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Despesa save(Despesa despesa) throws SQLException {
        try {
            String sql = "INSERT INTO T_DESPESA (TP_DESPESA, VL_DESPESA,DT_DESPESA, ID_USUARIO) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, despesa.getTipo_despesa());
            preparedStatement.setDouble(2, despesa.getValor_despesa());
            preparedStatement.setDate(3, despesa.getDt_despesa());
            preparedStatement.setInt(4, 1);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException ex) {
        throw new RuntimeException(ex);
        }
        return despesa;
    }

    @Override
    public Despesa update(Despesa despesa) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Despesa> findAll() {
        String sql = "SELECT ID_DESPESA ,VL_DESPESA, TP_DESPESA,DT_DESPESA,ID_USUARIO FROM T_DESPESA";

        List<Despesa> despesas = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("ID_DESPESA");
                String tipo = rs.getString("TP_DESPESA");
                Date data = rs.getDate("DT_DESPESA");
                double valor_despesa = rs.getDouble("VL_DESPESA");
                Integer id_usuario = rs.getInt("ID_USUARIO");

                Despesa despesa = new Despesa(valor_despesa,data,tipo,id_usuario,id);
                despesas.add(despesa);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return despesas;
    }

    @Override
    public Optional<Despesa> findById(Long id) {
        String sql = "SELECT ID_DESPESA, VL_DESPESA, DT_DESPESA, TP_DESPESA FROM T_DESPESA WHERE ID_DESPESA = ?";
        Despesa despesa = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("ID_DESPESA");
                String tipo = rs.getString("TP_DESPESA");
                Date data = rs.getDate("DT_DESPESA");
                double valor_despesa = rs.getDouble("VL_DESPESA");
                Integer id_usuario = rs.getInt("ID_USUARIO");

                despesa = new Despesa(valor_despesa,data,tipo,id_usuario);

            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(despesa);
    }
}
