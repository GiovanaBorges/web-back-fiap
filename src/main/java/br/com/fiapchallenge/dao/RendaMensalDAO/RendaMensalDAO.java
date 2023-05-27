package br.com.fiapchallenge.dao.RendaMensalDAO;

import br.com.fiapchallenge.model.RendaMensal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RendaMensalDAO implements IRendaMensalDAO{

    private final Connection connection;

    public RendaMensalDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public RendaMensal save(RendaMensal rendaMensal) {
        try {
            String sql = "INSERT INTO t_rendamensal (valor, data, dsc_renda, id_conta,id_usuario) VALUES (?, ?, ?, ?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1, rendaMensal.getRendaMensal());
            preparedStatement.setDate(2, java.sql.Date.valueOf(rendaMensal.getData().toLocalDate()));
            preparedStatement.setString(3, rendaMensal.getRenda());
            preparedStatement.setInt(4, rendaMensal.getConta());
            preparedStatement.setInt(5, rendaMensal.getUsuario());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return rendaMensal;
    }

    @Override
    public RendaMensal update(RendaMensal rendaMensal) {
        try {
            String sql = "UPDATE t_rendamensal SET rendaMensal = ?, data = ?, dsc_renda = ?, id_conta = ? , id_usuario = ? WHERE Id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, rendaMensal.getRendaMensal());
            preparedStatement.setDate(2, java.sql.Date.valueOf(rendaMensal.getData().toLocalDate()));
            preparedStatement.setString(3, rendaMensal.getRenda());
            preparedStatement.setInt(4 , rendaMensal.getConta());
            preparedStatement.setLong(5, rendaMensal.getUsuario());
            preparedStatement.setLong(6, rendaMensal.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return rendaMensal;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM t_rendamensal WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<RendaMensal> findAll() {
        String sql = "SELECT Id,valor, data, dsc_renda, id_conta,id_usuario FROM t_rendamensal";

        List<RendaMensal> rendamensalArray = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("Id");
                String descricao = rs.getString("dsc_renda");
                Date data = rs.getDate("data");
                double valor = rs.getDouble("valor");
                int idConta = rs.getInt("id_conta");
                int idUsuario = rs.getInt("id_usuario");

                RendaMensal rendamensal = new RendaMensal(id, valor, data,descricao ,idConta,idUsuario);
                rendamensalArray.add(rendamensal);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return rendamensalArray;
    }

    @Override
    public Optional<RendaMensal> findById(Long id) {
        String sql = "SELECT Id, data, dsc_renda, id_conta,id_usuario FROM t_rendamensal WHERE id = ?";

        RendaMensal rendaMensal = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("Id");
                String descricao = rs.getString("dsc_renda");
                Date data = rs.getDate("data");
                double valor = rs.getDouble("valor");
                Integer id_usuario = rs.getInt("id_usuario");
                Integer id_conta = rs.getInt("id_conta");

                rendaMensal = new RendaMensal(pKey,valor,data,descricao,id_conta,id_usuario);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(rendaMensal);
    }


}
