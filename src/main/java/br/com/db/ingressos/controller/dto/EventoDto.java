package br.com.db.ingressos.controller.dto;

import br.com.db.ingressos.model.Evento;

import javax.validation.constraints.NotBlank;

public class EventoDto {
    private Long id;
    @NotBlank(message = "Nome obrigatório!")
    private String nome;
    private String endereco;

    public EventoDto(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.endereco = evento.getEndereco();
    }

    public EventoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
