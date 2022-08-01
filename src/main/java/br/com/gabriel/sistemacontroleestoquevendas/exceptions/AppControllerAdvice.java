package br.com.gabriel.sistemacontroleestoquevendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(FormularioInvalidoException.class)
    public ResponseEntity tratarFormularioInvalidoException(FormularioInvalidoException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LoginOuSenhaInvalidosException.class)
    public ResponseEntity tratarLoginOuSenhaInvalidosException(LoginOuSenhaInvalidosException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity tratarRuntimeException(RuntimeException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
