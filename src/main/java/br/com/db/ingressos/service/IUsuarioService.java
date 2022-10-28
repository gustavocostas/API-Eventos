package br.com.db.ingressos.service;

import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.resposta.UsuarioAtualizadoResposta;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    UsuarioDto cadastrarUsuario(UsuarioDto usuarioDto);

    List<UsuarioDto> listarUsuario();

    Optional<UsuarioDto> encontrarUsuarioPorId(Long id);

    UsuarioDto atualizarUsuario(UsuarioAtualizadoResposta usuarioAtualizadoResposta);

    void deletarUsuario(Long id);
}
