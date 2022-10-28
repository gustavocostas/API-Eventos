package br.com.db.ingressos.controller;

import br.com.db.ingressos.config.docs.EventoDocs;
import br.com.db.ingressos.controller.dto.EventoDto;
import br.com.db.ingressos.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController implements EventoDocs {
    @Autowired
    IEventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoDto> cadastrarEvento(@RequestBody @Valid EventoDto eventoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.cadastrarEvento(eventoDto));
    }

    @GetMapping
    public ResponseEntity<List<EventoDto>> listarEvento() {
        return ResponseEntity.ok(eventoService.listarEvento());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EventoDto>> encontrarEventoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.encontrarEventoPorId(id));
    }

    @PutMapping
    public ResponseEntity<EventoDto> atualizarEvento(@RequestBody @Valid EventoDto eventoDto) {
        EventoDto evento = this.eventoService.atualizarEvento(eventoDto);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
        return ResponseEntity.ok(id);
    }
}
