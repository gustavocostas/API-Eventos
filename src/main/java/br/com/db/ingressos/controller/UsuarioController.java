package br.com.db.ingressos.controller;

import br.com.db.ingressos.config.docs.UsuarioDocs;
import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.resposta.UsuarioAtualizadoResposta;
import br.com.db.ingressos.resposta.UsuarioResposta;
import br.com.db.ingressos.mapper.UsuarioMapper;
import br.com.db.ingressos.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements UsuarioDocs {

    @Autowired
    IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResposta> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsuarioResposta form = UsuarioMapper.dtoParaResposta(usuarioService.cadastrarUsuario(usuarioDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(form);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResposta>> listarUsuario() {
        List<UsuarioResposta> resposta = UsuarioMapper.ListDtoParaResposta(usuarioService.listarUsuario());
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResposta> encontrarUsuarioPorId(@PathVariable Long id) {
        UsuarioResposta form = UsuarioMapper.OptionalDtoParaResposta(usuarioService.encontrarUsuarioPorId(id));
        return ResponseEntity.ok(form);
    }

    @PutMapping
    public ResponseEntity<UsuarioAtualizadoResposta> atualizarUsuario(
            @RequestBody @Valid UsuarioAtualizadoResposta usuarioDto) {
        UsuarioAtualizadoResposta atualizado = UsuarioMapper
                .dtoParaAtualizadoResposta(usuarioService.atualizarUsuario(usuarioDto));
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok(id);
    }
}
