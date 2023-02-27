package br.com.db.ingressos.service.impl;

import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.exception.EntityNotFoundException;
import br.com.db.ingressos.mapper.UsuarioMapper;
import br.com.db.ingressos.model.Usuario;
import br.com.db.ingressos.repository.IUsuarioRepository;
import br.com.db.ingressos.resposta.UsuarioAtualizadoResposta;
import br.com.db.ingressos.service.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto cadastrarUsuario(UsuarioDto usuarioDto) {
        return UsuarioMapper.usuarioParaDto(usuarioRepository.saveUsuario(UsuarioMapper.dtoParaUsuario(usuarioDto)));
    }

    public List<UsuarioDto> listarUsuario() {
        return usuarioRepository.listarUsuario().stream().map(UsuarioMapper::usuarioParaDto).toList();
    }

    public Optional<UsuarioDto> encontrarUsuarioPorId(Long id) {
        return usuarioRepository.findByIdUsuario(id).map(UsuarioMapper::usuarioParaDto);
    }

    public UsuarioDto atualizarUsuario(UsuarioAtualizadoResposta usuarioAtualizadoResposta) {
        Optional<Usuario> usuario = usuarioRepository.findByIdUsuario(usuarioAtualizadoResposta.getId());
        Usuario usuarioAtualizado = usuario.get();
        usuarioAtualizado.setNome(usuarioAtualizadoResposta.getNome());
        usuarioAtualizado.setSenha(usuarioAtualizadoResposta.getSenha());
        return UsuarioMapper.usuarioParaDto(usuarioRepository.saveUsuario(usuarioAtualizado));
    }

    public void deletarUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findByIdUsuario(id);
        usuario.orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado para excluir."));
        usuarioRepository.deleteByIdUsuario(id);
    }
}
