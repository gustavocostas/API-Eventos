package br.com.db.ingressos.service.impl;

import br.com.db.ingressos.controller.dto.IngressoDto;
import br.com.db.ingressos.exception.EntityNotFoundException;
import br.com.db.ingressos.mapper.IngressoMapper;
import br.com.db.ingressos.model.Ingresso;
import br.com.db.ingressos.repository.IIngressoRepository;
import br.com.db.ingressos.service.IIngressoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngressoService implements IIngressoService {
    IIngressoRepository ingressoRepository;

    public IngressoService(IIngressoRepository ingressoRepository){
        this.ingressoRepository = ingressoRepository;
    }

    public IngressoDto cadastrarIngresso(IngressoDto ingressoDto) {
        return IngressoMapper.ingressoParaDto(ingressoRepository.saveIngresso(IngressoMapper.dtoParaIngresso(ingressoDto)));
    }

    public List<IngressoDto> listarIngresso() {
        return ingressoRepository.listarIngresso().stream().map(IngressoMapper::ingressoParaDto).toList();
    }

    public Optional<IngressoDto> encontrarIngressoPorId(Long id) {
        return ingressoRepository.findByIdIngresso(id).map(IngressoMapper::ingressoParaDto);
    }

    public void deletarIngresso(Long id) {
        Optional<Ingresso> ingresso = ingressoRepository.findByIdIngresso(id);
        ingresso.orElseThrow(
                () -> new EntityNotFoundException("Ingresso não encontrado para excluir.")
        );
        ingressoRepository.deleteByIdIngresso(id);
    }
}
