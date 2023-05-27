package br.com.fiapchallenge.dao.ContaUsuario;

import br.com.fiapchallenge.model.ContaUsuario;
import br.com.fiapchallenge.model.Gastos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContaUsuarioDAO implements IContaUsuario{

    private final Connection connection;

    public ContaUsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ContaUsuario save(ContaUsuario contausuario) {
        try {
            String sql = "INSERT INTO t_contaUsuario (nr, agencia, banco, usuario) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, contausuario.getNumero());
            preparedStatement.setString(2, contausuario.getAgencia());
            preparedStatement.setString(3, contausuario.getBanco());
            preparedStatement.setString(4, contausuario.getUsuario());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return contausuario;
    }

    @Override
    public ContaUsuario update(ContaUsuario contaUsuario) {
        try {
            String sql = "UPDATE t_contaUsuario SET nr = ?, agencia = ?, banco = ?, usuario = ? WHERE Id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, contaUsuario.getNumero());
            preparedStatement.setString(2, contaUsuario.getAgencia());
            preparedStatement.setString(3, contaUsuario.getBanco());
            preparedStatement.setString(4 , contaUsuario.getUsuario());
            preparedStatement.setLong(5, contaUsuario.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return contaUsuario;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM t_contaUsuario WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<ContaUsuario> findAll() {
        String sql = "SELECT Id, nr, agencia, banco, usuario FROM t_contaUsuario";

        List<ContaUsuario> contaUsuario = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("Id");
                String nr_agencia = rs.getString("agencia");
                String banco = rs.getString("banco");
                Integer nr_conta = rs.getInt("nr");
                String usuario = rs.getString("usuario");

                ContaUsuario conta = new ContaUsuario(nr_conta,nr_agencia,banco,usuario,id);
                contaUsuario.add(conta);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return contaUsuario;
    }

    @Override
    public Optional<ContaUsuario> findById(Long id) {
        String sql = "SELECT Id, nr, agencia, banco, usuario FROM t_contaUsuario WHERE Id = ?";
        ContaUsuario conta = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("Id");
                String nr_agencia = rs.getString("agencia");
                String banco = rs.getString("banco");
                Integer nr_conta = rs.getInt("nr");
                String usuario = rs.getString("usuario");

                conta = new ContaUsuario(nr_conta,nr_agencia,banco,usuario);

            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(conta);
    }
}
