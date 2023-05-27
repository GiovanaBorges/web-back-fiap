package br.com.fiapchallenge.dao.UsuarioDAO;

import br.com.fiapchallenge.dao.ContaUsuario.IContaUsuario;
import br.com.fiapchallenge.model.Gastos;
import br.com.fiapchallenge.model.RendaMensal;
import br.com.fiapchallenge.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO implements IUsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            String sql = "INSERT INTO t_usuario (usuario,senha) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return usuario;
    }


    @Override
    public Usuario update(Usuario usuario) {
        try {
            String sql = "UPDATE t_usuario SET usuario = ?, senha = ? WHERE Id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setLong(3, usuario.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return usuario;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM t_usuario WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT Id,usuario, senha FROM t_usuario";

        List<Usuario> usuarioArray = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("Id");
                String usuario_bd = rs.getString("usuario");
                String senha = rs.getString("senha");


                Usuario usuario = new Usuario(id,usuario_bd,senha);
                usuarioArray.add(usuario);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return usuarioArray;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        String sql = "SELECT Id,usuario, senha FROM t_usuario WHERE Id = ?";
        Usuario usuario = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("Id");
                String usuario_bd = rs.getString("usuario");
                String senha = rs.getString("senha");

                usuario = new Usuario(pKey,usuario_bd,senha);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(usuario);
    }
}
