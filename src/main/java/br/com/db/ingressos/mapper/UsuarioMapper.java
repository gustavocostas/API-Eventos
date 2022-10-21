package br.com.db.ingressos.mapper;

import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.model.Usuario;
import org.modelmapper.ModelMapper;

public class UsuarioMapper {
    public static UsuarioDto usuarioParaDTO(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDto.class);
    }

    public static Usuario dtoParaUsuario(UsuarioDto usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
}
