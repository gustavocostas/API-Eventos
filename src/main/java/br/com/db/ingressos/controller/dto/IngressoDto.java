package br.com.db.ingressos.controller.dto;

import br.com.db.ingressos.model.CategoriaIngresso;
import br.com.db.ingressos.model.Evento;
import br.com.db.ingressos.model.Ingresso;
import br.com.db.ingressos.model.Usuario;

import javax.validation.constraints.NotNull;

public class IngressoDto {
    private Long id;
    private CategoriaIngresso categoriaIngresso;
    @NotNull(message = "Preço obrigatório!")
    private Double preco;
    private Usuario usuario;
    private Evento evento;

    public IngressoDto(Ingresso ingresso) {
        this.id = ingresso.getId();
        this.categoriaIngresso = ingresso.getCategoriaIngresso();
        this.preco = ingresso.getPreco();
        this.usuario = ingresso.getUsuario();
        this.evento = ingresso.getEvento();
    }

    public IngressoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaIngresso getCategoriaIngresso() {
        return categoriaIngresso;
    }

    public void setCategoriaIngresso(CategoriaIngresso categoriaIngresso) {
        this.categoriaIngresso = categoriaIngresso;
    }

    public Double getPreco() {
        if (categoriaIngresso == CategoriaIngresso.PISTA) {
            return this.preco;
        } else if (categoriaIngresso == CategoriaIngresso.VIP) {
            return this.preco + ((this.preco * 30) / 100);
        } else if (categoriaIngresso == CategoriaIngresso.CAMAROTE) {
            return this.preco + ((this.preco * 60) / 100);
        }
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
