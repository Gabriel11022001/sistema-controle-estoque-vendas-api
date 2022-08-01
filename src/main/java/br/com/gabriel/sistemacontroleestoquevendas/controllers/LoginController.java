package br.com.gabriel.sistemacontroleestoquevendas.controllers;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.services.FuncionarioService;
import br.com.gabriel.sistemacontroleestoquevendas.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody FuncionarioDTO funcionarioDTO) {
        return this.loginService.login(funcionarioDTO.getLogin(), funcionarioDTO.getSenha());
    }
}
