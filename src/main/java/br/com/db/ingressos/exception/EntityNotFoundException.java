package br.com.db.ingressos.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }
}
