package br.com.db.ingressos.service;

import br.com.db.ingressos.controller.dto.EventoDto;

import java.util.List;
import java.util.Optional;

public interface IEventoService {
    EventoDto cadastrarEvento(EventoDto eventoDto);

    List<EventoDto> listarEvento();

    Optional<EventoDto> encontrarEventoPorId(Long id);

    EventoDto atualizarEvento(EventoDto eventoDto);

    void deletarEvento(Long id);
}
