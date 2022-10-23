package br.com.db.ingressos.resposta;

import br.com.db.ingressos.model.Usuario;

public class UsuarioResposta {
    private Long id;
    private String nome;
    private String cpf;

    public UsuarioResposta(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
    }

    public UsuarioResposta() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
