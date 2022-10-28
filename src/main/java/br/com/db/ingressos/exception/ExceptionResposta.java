package br.com.db.ingressos.exception;

import java.util.List;

public class ExceptionResposta {
    private List<ExceptionCampoResposta> exceptionCampoRespostas;

    public ExceptionResposta() {
    }

    public List<ExceptionCampoResposta> getExceptionCampoRespostas() {
        return exceptionCampoRespostas;
    }

    public void setExceptionCampoRespostas(List<ExceptionCampoResposta> campoRespostas) {
        this.exceptionCampoRespostas = campoRespostas;
    }
}
