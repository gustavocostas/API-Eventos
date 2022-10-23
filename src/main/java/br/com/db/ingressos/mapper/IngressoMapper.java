package br.com.db.ingressos.mapper;

import br.com.db.ingressos.controller.dto.IngressoDto;
import br.com.db.ingressos.resposta.IngressoResposta;
import br.com.db.ingressos.model.Ingresso;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IngressoMapper {
    public static IngressoDto ingressoParaDto(Ingresso ingresso) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ingresso, IngressoDto.class);
    }

    public static Ingresso dtoParaIngresso(IngressoDto ingressoDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ingressoDto, Ingresso.class);
    }

    public static IngressoResposta dtoParaResposta(IngressoDto ingressoDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ingressoDto, IngressoResposta.class);
    }

    public static IngressoResposta OptionalDtoParaResposta(Optional<IngressoDto> ingressoDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ingressoDto, IngressoResposta.class);
    }

    public static List<IngressoResposta> ListDtoParaResposta(List<IngressoDto> ingressoDto) {
        ModelMapper modelMapper = new ModelMapper();
        return ingressoDto
                .stream()
                .map(ingresso -> modelMapper.map(ingresso, IngressoResposta.class))
                .collect(Collectors.toList());
    }
}
