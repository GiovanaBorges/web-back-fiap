package br.com.fiapchallenge.dao.investimento;

import br.com.fiapchallenge.model.Investimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvestimentoDAO implements IInvestimento{

    private final Connection connection;

    public InvestimentoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Investimento save(Investimento investimento) {
        try {
            String sql = "INSERT INTO T_INVESTIMENTO (VL_INVESTIMENTO,NM_INVESTIMENTO,DS_INVESTIMENTO,DT_INICIAL,DT_FINAL,ID_USUARIO) VALUES (?, ?, ?, ?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDouble(1,investimento.getVl_investimento());
            preparedStatement.setString(2,"investimento nubank asset");
            preparedStatement.setString(3,investimento.getDescri_investimento());
            preparedStatement.setDate(4,investimento.getData_inicial());
            preparedStatement.setDate(5,investimento.getData_inicial());
            preparedStatement.setInt(6, 1);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return investimento;
    }

    @Override
    public Investimento update(Investimento investimento) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Investimento> findAll() {
        String sql = "SELECT ID_INVESTIMENTO,VL_INVESTIMENTO,NM_INVESTIMENTO,DS_INVESTIMENTO,DT_INICIAL,DT_FINAL,ID_USUARIO FROM T_INVESTIMENTO";
        List<Investimento> investimentos = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("ID_INVESTIMENTO");
                String nome = rs.getString("NM_INVESTIMENTO");
                Date data = rs.getDate("DT_INICIAL");
                double valor_invest = rs.getDouble("VL_INVESTIMENTO");
                String descri = rs.getString("DS_INVESTIMENTO");
                Integer id_usuario = rs.getInt("ID_USUARIO");

                Investimento investimento = new Investimento(pKey,valor_invest, data,data,nome,descri,id_usuario);
                investimentos.add(investimento);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return investimentos;
    }

    @Override
    public Optional<Investimento> findById(Long id) {
        return Optional.empty();
    }
}