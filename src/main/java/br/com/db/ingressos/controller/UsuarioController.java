package br.com.db.ingressos.controller;

import br.com.db.ingressos.config.docs.UsuarioDocs;
import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements UsuarioDocs {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuarioDto));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuario() {
        return ResponseEntity.ok(usuarioService.listarUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioDto>> encontrarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.encontrarUsuario(id));
    }

    @PutMapping
    public ResponseEntity<UsuarioDto> atualizarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok(id);
    }
}
