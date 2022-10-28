package br.com.db.ingressos.controller;

import br.com.db.ingressos.config.docs.IngressoDocs;
import br.com.db.ingressos.controller.dto.IngressoDto;
import br.com.db.ingressos.resposta.IngressoResposta;
import br.com.db.ingressos.mapper.IngressoMapper;
import br.com.db.ingressos.service.IIngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressoController implements IngressoDocs {
    @Autowired
    IIngressoService ingressoService;

    @PostMapping
    public ResponseEntity<IngressoResposta> cadastrarIngresso(@RequestBody IngressoDto ingressoDto) {
        IngressoResposta resposta = IngressoMapper.dtoParaResposta(ingressoService.cadastrarIngresso(ingressoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<IngressoResposta>> listarIngresso() {
        List<IngressoResposta> resposta = IngressoMapper.ListDtoParaResposta(ingressoService.listarIngresso());
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngressoResposta> encontrarIngressoPorId(@PathVariable Long id) {
        IngressoResposta form = IngressoMapper.OptionalDtoParaResposta(ingressoService.encontrarIngressoPorId(id));
        return ResponseEntity.ok(form);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletarIngresso(@PathVariable Long id) {
        ingressoService.deletarIngresso(id);
        return ResponseEntity.ok(id);
    }
}
