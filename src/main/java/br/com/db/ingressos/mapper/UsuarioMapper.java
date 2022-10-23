package br.com.db.ingressos.mapper;

import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.resposta.UsuarioAtualizadoResposta;
import br.com.db.ingressos.resposta.UsuarioResposta;
import br.com.db.ingressos.model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static UsuarioDto usuarioParaDto(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDto.class);
    }

    public static Usuario dtoParaUsuario(UsuarioDto usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioDTO, Usuario.class);
    }

    public static UsuarioResposta dtoParaResposta(UsuarioDto usuarioDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioDto, UsuarioResposta.class);
    }

    public static UsuarioResposta OptionalDtoParaResposta(Optional<UsuarioDto> usuarioDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioDto, UsuarioResposta.class);
    }

    public static List<UsuarioResposta> ListDtoParaResposta(List<UsuarioDto> usuarioDto) {
        ModelMapper modelMapper = new ModelMapper();
        return usuarioDto
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResposta.class))
                .collect(Collectors.toList());
    }

    public static UsuarioAtualizadoResposta dtoParaAtualizadoResposta(UsuarioDto usuarioDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioDto, UsuarioAtualizadoResposta.class);
    }
}
