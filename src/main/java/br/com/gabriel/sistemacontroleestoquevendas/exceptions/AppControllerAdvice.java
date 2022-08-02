package br.com.gabriel.sistemacontroleestoquevendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(LoginOuSenhaInvalidosException.class)
    public ResponseEntity tratarLoginOuSenhaInvalidosException(LoginOuSenhaInvalidosException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity tratarRuntimeException(RuntimeException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> errosObjetos = e.getBindingResult()
                .getAllErrors();
        List<String> mensagensErro = new ArrayList<>();
        for (ObjectError objectError : errosObjetos) {
            mensagensErro.add(objectError.getDefaultMessage());
        }
        return new ResponseEntity(mensagensErro, HttpStatus.BAD_REQUEST);
    }
}
