package br.com.db.ingressos.controller.dto;

import br.com.db.ingressos.model.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {
    private Long id;
    @NotBlank
    private String nome;
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    @Length(min = 8)
    private String senha;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public UsuarioDto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
