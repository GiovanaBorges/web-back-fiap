package br.com.fiapchallenge.dao.ContaUsuario;

import br.com.fiapchallenge.model.ContaUsuario;

import java.util.List;
import java.util.Optional;

public interface IContaUsuario {
    ContaUsuario save(ContaUsuario contausuario);

    ContaUsuario update(ContaUsuario contaUsuario);

    void delete(Long id);

    List<ContaUsuario> findAll();

    Optional<ContaUsuario> findById(Long id);
}
