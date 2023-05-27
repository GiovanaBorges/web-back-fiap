package br.com.fiapchallenge.dao.RendaMensalDAO;

import br.com.fiapchallenge.model.RendaMensal;

import java.util.List;
import java.util.Optional;

public interface IRendaMensalDAO {
    RendaMensal save(RendaMensal rendaMensal);
    RendaMensal update(RendaMensal rendaMensal);
    void delete(Long id);
    List<RendaMensal> findAll();
    Optional<RendaMensal> findById(Long id);
}
