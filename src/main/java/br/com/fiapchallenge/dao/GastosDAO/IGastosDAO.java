package br.com.fiapchallenge.dao.GastosDAO;

import br.com.fiapchallenge.model.Gastos;

import java.util.List;
import java.util.Optional;

public interface IGastosDAO {
    Gastos save(Gastos gastos);

    Gastos update(Gastos gastos);

    void delete(Long id);

    List<Gastos> findAll();

    Optional<Gastos> findById(Long id);
}
