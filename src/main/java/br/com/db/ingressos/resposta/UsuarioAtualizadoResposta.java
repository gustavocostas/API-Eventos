package br.com.db.ingressos.resposta;

import br.com.db.ingressos.model.Usuario;

public class UsuarioAtualizadoResposta {
    private Long id;
    private String nome;
    private String senha;

    public UsuarioAtualizadoResposta(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    public UsuarioAtualizadoResposta() {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
