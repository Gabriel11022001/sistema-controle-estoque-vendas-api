package br.com.gabriel.sistemacontroleestoquevendas.services;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.exceptions.LoginOuSenhaInvalidosException;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.FuncionarioRepository;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverteFuncionarioEmFuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ValidaFormularioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public ResponseEntity login(String login, String senha) {

        ValidaFormularioLogin validaFormularioLogin = new ValidaFormularioLogin();
        validaFormularioLogin.validarFormularioDeLogin(login, senha);
        Funcionario funcionario = this.funcionarioRepository.buscarFuncionarioPeloLoginESenha(login, senha);
        if (funcionario == null) {
            throw new LoginOuSenhaInvalidosException("Login ou senha inválidos!");
        }
        FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO()
                .converter(funcionario);
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }
}
