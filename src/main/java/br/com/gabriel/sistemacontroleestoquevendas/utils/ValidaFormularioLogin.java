package br.com.gabriel.sistemacontroleestoquevendas.utils;

import br.com.gabriel.sistemacontroleestoquevendas.exceptions.FormularioInvalidoException;

public class ValidaFormularioLogin {

    public void validarFormularioDeLogin(String login, String senha) {
        if (login == null || senha == null || login.isEmpty() || senha.isEmpty()) {
            throw new FormularioInvalidoException("Informe o login e a senha!");
        }
    }
}
