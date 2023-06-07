package br.com.fiapchallenge.dao.investimento;

import br.com.fiapchallenge.model.Despesa;
import br.com.fiapchallenge.model.Investimento;

import java.util.List;
import java.util.Optional;

public interface IInvestimento {
    Investimento save(Investimento investimento);

    Investimento update(Investimento investimento);

    void delete(Long id);

    List<Investimento> findAll();

    Optional<Investimento> findById(Long id);
}
