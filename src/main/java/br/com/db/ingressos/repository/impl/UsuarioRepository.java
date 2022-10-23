package br.com.db.ingressos.repository.impl;

import br.com.db.ingressos.model.Usuario;
import br.com.db.ingressos.repository.IUsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements IUsuarioRepository {
    private final RepositorySpringData repositorySpringData;

    public UsuarioRepository(final RepositorySpringData repositorySpringData) {
        this.repositorySpringData = repositorySpringData;
    }

    @Override
    public Usuario saveUsuario(final Usuario usuario) {
        return this.repositorySpringData.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return this.repositorySpringData.findAll();
    }

    @Override
    public Optional<Usuario> findByIdUsuario(final Long id) {
        return this.repositorySpringData.findById(id);
    }

    @Override
    public void deleteByIdUsuario(Long id) {
        this.repositorySpringData.deleteById(id);
    }

    private interface RepositorySpringData extends JpaRepository<Usuario, Long> {
    }
}
