package br.com.db.ingressos.repository.impl;

import br.com.db.ingressos.model.Evento;
import br.com.db.ingressos.repository.IEventoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventoRepository implements IEventoRepository {
    private final RepositorySpringData repositorySpringData;

    public EventoRepository(final RepositorySpringData repositorySpringData) {
        this.repositorySpringData = repositorySpringData;
    }

    @Override
    public Evento saveEvento(Evento evento) {
        return this.repositorySpringData.save(evento);
    }

    @Override
    public List<Evento> listarEvento() {
        return this.repositorySpringData.findAll();
    }

    @Override
    public Optional<Evento> findByIdEvento(final Long id) {
        return this.repositorySpringData.findById(id);
    }

    @Override
    public void deleteByIdEvento(Long id) {
        this.repositorySpringData.deleteById(id);
    }

    private interface RepositorySpringData extends JpaRepository<Evento, Long> {
    }
}
