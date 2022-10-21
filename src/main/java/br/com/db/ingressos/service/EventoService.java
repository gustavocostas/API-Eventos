package br.com.db.ingressos.service;

import br.com.db.ingressos.controller.dto.EventoDto;
import br.com.db.ingressos.mapper.EventoMapper;
import br.com.db.ingressos.model.Evento;
import br.com.db.ingressos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    EventoRepository eventoRepository;

    public EventoDto cadastrarEvento(EventoDto eventoDto) {
        return EventoMapper.eventoParaDto(eventoRepository.save(EventoMapper.dtoParaEvento(eventoDto)));
    }

    public List<EventoDto> listarEvento() {
        return eventoRepository.findAll().stream().map(EventoMapper::eventoParaDto).toList();
    }

    public Optional<EventoDto> encontrarEventoPorId(Long id) {
        return eventoRepository.findById(id).map(EventoMapper::eventoParaDto);
    }

    public EventoDto atualizarEvento(EventoDto eventoDto) {
        Optional<Evento> evento = eventoRepository.findById(eventoDto.getId());
        Evento eventoAtualizado = evento.get();
        eventoAtualizado.setNome(eventoDto.getNome());
        eventoAtualizado.setPreco(eventoAtualizado.getPreco());
        eventoAtualizado.setEndereco(eventoDto.getEndereco());
        return EventoMapper.eventoParaDto(eventoRepository.save(eventoAtualizado));
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
