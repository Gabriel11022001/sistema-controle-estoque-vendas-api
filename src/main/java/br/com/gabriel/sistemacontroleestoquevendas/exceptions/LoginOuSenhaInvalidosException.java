package br.com.gabriel.sistemacontroleestoquevendas.exceptions;

public class LoginOuSenhaInvalidosException extends RuntimeException {

    public LoginOuSenhaInvalidosException(String mensagem) {
        super(mensagem);
    }
}
