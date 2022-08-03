package br.com.gabriel.sistemacontroleestoquevendas.utils;

import javax.servlet.http.HttpSession;

public class VerificaUsuarioEstaLogado {

    public static void verificarSeUsuarioEstaLogado(HttpSession sessao, String mensagem) {
        if (sessao.getAttribute("usuario_logado") == null) {
            throw new RuntimeException(mensagem);
        }
    }
}
