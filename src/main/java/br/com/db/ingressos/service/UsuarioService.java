package br.com.db.ingressos.service;

import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.mapper.UsuarioMapper;
import br.com.db.ingressos.model.Usuario;
import br.com.db.ingressos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDto cadastrarUsuario(UsuarioDto usuarioDto) {
        return UsuarioMapper.usuarioParaDTO(usuarioRepository.save(UsuarioMapper.dtoParaUsuario(usuarioDto)));
    }

    public List<UsuarioDto> listarUsuario() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper::usuarioParaDTO).toList();
    }

    public Optional<UsuarioDto> encontrarUsuario(Long id) {
        return usuarioRepository.findById(id).map(UsuarioMapper::usuarioParaDTO);
    }

    public UsuarioDto atualizarUsuario(UsuarioDto usuarioDto) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioDto.getId());
        Usuario usuarioAtualizado = usuario.get();
        usuarioAtualizado.setNome(usuarioDto.getNome());
        usuarioAtualizado.setCpf(usuarioDto.getCpf());
        usuarioAtualizado.setEmail(usuarioDto.getEmail());
        usuarioAtualizado.setSenha(usuarioDto.getSenha());
        return UsuarioMapper.usuarioParaDTO(usuarioRepository.save(usuarioAtualizado));
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
