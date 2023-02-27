package br.com.db.ingressos.repository.impl;

import br.com.db.ingressos.model.Ingresso;
import br.com.db.ingressos.repository.IIngressoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngressoRepository implements IIngressoRepository {
    private final RepositorySpringData repositorySpringData;

    public IngressoRepository(final RepositorySpringData repositorySpringData) {
        this.repositorySpringData = repositorySpringData;
    }

    @Override
    public Ingresso saveIngresso(Ingresso ingresso) {
        return this.repositorySpringData.save(ingresso);
    }

    @Override
    public List<Ingresso> listarIngresso() {
        return this.repositorySpringData.findAll();
    }

    @Override
    public Optional<Ingresso> findByIdIngresso(final Long id) {
        return this.repositorySpringData.findById(id);
    }

    @Override
    public void deleteByIdIngresso(Long id) {
        this.repositorySpringData.deleteById(id);
    }

    private interface RepositorySpringData extends JpaRepository<Ingresso, Long> {
    }
}
