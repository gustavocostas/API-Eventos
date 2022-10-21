package br.com.db.ingressos.controller.dto;

import br.com.db.ingressos.model.Evento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EventoDto {
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private Double preco;
    private String endereco;

    public EventoDto(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.preco = evento.getPreco();
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
