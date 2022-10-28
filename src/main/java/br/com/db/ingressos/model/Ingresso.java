package br.com.db.ingressos.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CategoriaIngresso categoriaIngresso;
    private Double preco;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Evento evento;
    private LocalDateTime localDateTime = LocalDateTime.now();

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
