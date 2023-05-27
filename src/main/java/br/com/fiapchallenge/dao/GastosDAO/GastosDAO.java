package br.com.fiapchallenge.dao.GastosDAO;

import br.com.fiapchallenge.model.Gastos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GastosDAO implements IGastosDAO{

    private final Connection connection;

    public GastosDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Gastos save(Gastos gastos) {
        try{
            String sql = "INSERT INTO t_gastos(nr_conta,dt_gastos,dsc_gastos,id_usuario,vl_gastos) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, gastos.getConta());
            preparedStatement.setDate(2, gastos.getData());
            preparedStatement.setString(3, gastos.getGastos());
            preparedStatement.setInt(4, gastos.getUsuario());
            preparedStatement.setDouble(5, gastos.getValor());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();


            preparedStatement.close();
            resultSet.close();
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }

        return gastos;
    }

    @Override
    public Gastos update(Gastos gastos) {
        try {
            String sql = "UPDATE t_gastos SET dsc_gastos = ?, dt_gastos = ?, vl_gastos = ?, nr_conta = ? , id_usuario = ? WHERE Id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, gastos.getGastos());
            preparedStatement.setDate(2, gastos.getData());
            preparedStatement.setDouble(3, gastos.getValor());
            preparedStatement.setInt(4 , gastos.getConta());
            preparedStatement.setLong(5, gastos.getUsuario());
            preparedStatement.setLong(6, gastos.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
      return gastos;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM t_gastos WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Gastos> findAll() {
        String sql = "SELECT Id, dsc_gastos, dt_gastos, id_usuario, vl_gastos,nr_conta FROM t_gastos";

        List<Gastos> gastos = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("Id");
                String descricao = rs.getString("dsc_gastos");
                LocalDate data = rs.getDate("dt_gastos").toLocalDate();
                Integer idUser = rs.getInt("id_usuario");
                Integer nr_conta = rs.getInt("nr_conta");
                double valor = rs.getDouble("vl_gastos");

                Gastos gasto = new Gastos(id,Date.valueOf(data), descricao, idUser,nr_conta ,valor);
                gastos.add(gasto);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return gastos;
    }

    @Override
    public Optional<Gastos> findById(Long id) {
        String sql = "SELECT Id, dsc_gastos, dt_gastos, id_usuario, vl_gastos,nr_conta FROM t_gastos WHERE Id = ?";
        Gastos gasto = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("Id");
                String desc = rs.getString("dsc_gastos");
                Date data = rs.getDate("dt_gastos");
                double valor = rs.getDouble("vl_gastos");
                Integer id_usuario = rs.getInt("id_usuario");
                Integer nr_conta = rs.getInt("nr_conta");

                gasto = new Gastos(pKey,data,desc,nr_conta,id_usuario,valor);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(gasto);
    }
}
