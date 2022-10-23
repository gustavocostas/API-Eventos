package br.com.db.ingressos.resposta;

import br.com.db.ingressos.model.CategoriaIngresso;
import br.com.db.ingressos.model.Evento;
import br.com.db.ingressos.model.Ingresso;
import br.com.db.ingressos.model.Usuario;

public class IngressoResposta {
    private Long id;
    private CategoriaIngresso categoriaIngresso;
    private Usuario usuario;
    private Evento evento;

    public IngressoResposta(Ingresso ingresso) {
        this.id = ingresso.getId();
        this.categoriaIngresso = ingresso.getCategoriaIngresso();
        this.usuario = ingresso.getUsuario();
        this.evento = ingresso.getEvento();
    }

    public IngressoResposta() {
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
