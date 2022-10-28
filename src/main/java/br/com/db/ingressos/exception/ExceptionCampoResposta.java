package br.com.db.ingressos.exception;

public class ExceptionCampoResposta {
    private String mensagem;

    public ExceptionCampoResposta() {
    }

    public ExceptionCampoResposta(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
