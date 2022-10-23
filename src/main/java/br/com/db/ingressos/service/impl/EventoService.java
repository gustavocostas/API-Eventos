package br.com.db.ingressos.service.impl;

import br.com.db.ingressos.controller.dto.EventoDto;
import br.com.db.ingressos.exception.EntityNotFoundException;
import br.com.db.ingressos.mapper.EventoMapper;
import br.com.db.ingressos.model.Evento;
import br.com.db.ingressos.repository.IEventoRepository;
import br.com.db.ingressos.service.IEventoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements IEventoService {
    IEventoRepository eventoRepository;

    public EventoService(IEventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public EventoDto cadastrarEvento(EventoDto eventoDto) {
        return EventoMapper.eventoParaDto(eventoRepository.saveEvento(EventoMapper.dtoParaEvento(eventoDto)));
    }

    public List<EventoDto> listarEvento() {
        return eventoRepository.listarEvento().stream().map(EventoMapper::eventoParaDto).toList();
    }

    public Optional<EventoDto> encontrarEventoPorId(Long id) {
        return eventoRepository.findByIdEvento(id).map(EventoMapper::eventoParaDto);
    }

    public EventoDto atualizarEvento(EventoDto eventoDto) {
        Optional<Evento> evento = eventoRepository.findByIdEvento(eventoDto.getId());
        Evento eventoAtualizado = evento.get();
        eventoAtualizado.setNome(eventoDto.getNome());
        eventoAtualizado.setEndereco(eventoDto.getEndereco());
        return EventoMapper.eventoParaDto(eventoRepository.saveEvento(eventoAtualizado));
    }

    public void deletarEvento(Long id) {
        Optional<Evento> evento = eventoRepository.findByIdEvento(id);
        evento.orElseThrow(
                () -> new EntityNotFoundException("Evento não encontrado para excluir.")
        );
        eventoRepository.deleteByIdEvento(id);
    }
}
