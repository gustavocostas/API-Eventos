package br.com.db.ingressos.repository;

import br.com.db.ingressos.model.Evento;

import java.util.List;
import java.util.Optional;

public interface IEventoRepository {
    Evento saveEvento(Evento evento);
    List<Evento> listarEvento();
    Optional<Evento> findByIdEvento(Long id);
    void deleteByIdEvento(Long id);
}
