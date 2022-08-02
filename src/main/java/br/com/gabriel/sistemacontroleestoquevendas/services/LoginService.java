package br.com.gabriel.sistemacontroleestoquevendas.services;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.exceptions.LoginOuSenhaInvalidosException;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.FuncionarioRepository;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverteFuncionarioEmFuncionarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public ResponseEntity login(String login, String senha, HttpSession sessao) {

        Funcionario funcionario = this.funcionarioRepository.buscarFuncionarioPeloLoginESenha(login, senha);
        if (funcionario == null) {
            throw new LoginOuSenhaInvalidosException("Login ou senha inválidos!");
        }
        FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO()
                .converter(funcionario);
        sessao.setAttribute("usuario_logado", funcionarioDTO);
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }
    public ResponseEntity logout(HttpSession sessao) {
        if (sessao.getAttribute("usuario_logado") == null) {
            return new ResponseEntity("Não existe nenhum usuário logado!", HttpStatus.OK);
        }
        // Limpando a sessão
        sessao.invalidate();
        return new ResponseEntity("Logout efetivado com sucesso!", HttpStatus.OK);
    }
}
