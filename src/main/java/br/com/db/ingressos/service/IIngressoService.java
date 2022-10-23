package br.com.db.ingressos.service;

import br.com.db.ingressos.controller.dto.IngressoDto;

import java.util.List;
import java.util.Optional;

public interface IIngressoService {
    IngressoDto cadastrarIngresso(IngressoDto ingressoDto);

    List<IngressoDto> listarIngresso();

    Optional<IngressoDto> encontrarIngressoPorId(Long id);

    void deletarIngresso(Long id);
}
