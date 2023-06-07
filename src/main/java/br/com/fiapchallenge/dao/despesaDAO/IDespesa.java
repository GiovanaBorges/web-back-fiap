package br.com.fiapchallenge.dao.despesaDAO;

import br.com.fiapchallenge.model.Despesa;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDespesa {
    Despesa save(Despesa despesa) throws SQLException;

    Despesa update(Despesa despesa);

    void delete(Long id);

    List<Despesa> findAll();

    Optional<Despesa> findById(Long id);
}
