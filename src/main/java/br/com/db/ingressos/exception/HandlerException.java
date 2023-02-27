package br.com.db.ingressos.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> excecaoNotFound(Exception ex) {
        ExceptionResposta exceptionResposta = new ExceptionResposta();
        List<ExceptionCampoResposta> campoRespostas = new ArrayList<>();
        ExceptionCampoResposta exceptionCampoResposta = new ExceptionCampoResposta();
        exceptionCampoResposta.setMensagem(ex.getMessage());
        campoRespostas.add(exceptionCampoResposta);

        exceptionResposta.setExceptionCampoRespostas(campoRespostas);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResposta);
    }

    @ExceptionHandler(EntityBadRequestException.class)
    public ResponseEntity<Object> excecaoBadRequest() {
        ExceptionResposta exceptionResposta = handlerExceptionResposta();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResposta);
    }

    @ExceptionHandler(EntityNullPointerException.class)
    public ResponseEntity<Object> excecaoNullPointer() {
        ExceptionResposta exceptionResposta = handlerExceptionResposta();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResposta);
    }

    private ExceptionResposta handlerExceptionResposta() {
        ExceptionResposta exceptionResposta = new ExceptionResposta();
        List<ExceptionCampoResposta> campoErrors = new ArrayList<>();
        ExceptionCampoResposta exceptionCampoResposta = new ExceptionCampoResposta();
        exceptionCampoResposta.setMensagem("Argumentos não são válidos!");
        campoErrors.add(exceptionCampoResposta);

        exceptionResposta.setExceptionCampoRespostas(campoErrors);

        return exceptionResposta;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        ExceptionResposta exceptionResposta = handlerExceptionResposta();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResposta);
    }

}
