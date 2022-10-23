package br.com.db.ingressos.exception;

public class EntityBadRequestException extends RuntimeException {
    public EntityBadRequestException(String mensagem) {
        super(mensagem);
    }
}
