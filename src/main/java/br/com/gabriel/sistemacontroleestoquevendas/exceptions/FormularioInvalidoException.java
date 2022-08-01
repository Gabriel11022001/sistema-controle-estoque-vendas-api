package br.com.gabriel.sistemacontroleestoquevendas.exceptions;

public class FormularioInvalidoException extends RuntimeException {

    public FormularioInvalidoException(String mensagem) {
        super(mensagem);
    }
}
