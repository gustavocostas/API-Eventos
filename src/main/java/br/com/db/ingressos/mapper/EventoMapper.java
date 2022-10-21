package br.com.db.ingressos.mapper;

import br.com.db.ingressos.controller.dto.EventoDto;
import br.com.db.ingressos.model.Evento;
import org.modelmapper.ModelMapper;

public class EventoMapper {
    public static EventoDto eventoParaDto(Evento evento) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(evento, EventoDto.class);
    }

    public static Evento dtoParaEvento(EventoDto eventoDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(eventoDto, Evento.class);
    }
}
