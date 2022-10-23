package br.com.db.ingressos.repository;

import br.com.db.ingressos.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository {
    Usuario saveUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    Optional<Usuario> findByIdUsuario(Long id);
    void deleteByIdUsuario(Long id);
}
