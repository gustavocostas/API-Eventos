package br.com.db.ingressos.repository;

import br.com.db.ingressos.model.Ingresso;

import java.util.List;
import java.util.Optional;

public interface IIngressoRepository {
    Ingresso saveIngresso(Ingresso ingresso);
    List<Ingresso> listarIngresso();
    Optional<Ingresso> findByIdIngresso(Long id);
    void deleteByIdIngresso(Long id);
}
