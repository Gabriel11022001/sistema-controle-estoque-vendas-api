package br.com.gabriel.sistemacontroleestoquevendas.services;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.FuncionarioRepository;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverterFuncionarioDTOEmFuncionario;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ValidaFormularioCadastroFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public ResponseEntity cadastrarFuncionario(FuncionarioDTO funcionarioDTO, HttpSession sessao) {

        // Validar os valores enviados por meio do formulário para cadastro de funcionários
        ValidaFormularioCadastroFuncionario validaFormularioCadastroFuncionario = new ValidaFormularioCadastroFuncionario();
        validaFormularioCadastroFuncionario.validarFormulario(funcionarioDTO);
        List<String> erros = new ArrayList<>();
        // Verificar se já existe um funcionário com o e-mail informado
        if (this.funcionarioRepository.buscarFuncionarioPeloEmail(funcionarioDTO.getEmail()) != null) {
            erros.add("- Você não pode cadastrar um novo funcionário com esse e-mail pois já existe um funcionário cadastrado com o mesmo!");
        }
        // Verificar se já existe um funcionário cadastrado com o cpf informado
        if (this.funcionarioRepository.buscarFuncionarioPeloCpf(funcionarioDTO.getCpf()) != null) {
            erros.add("- Você não pode cadastrar um funcionário com esse cpf pois já existe um funcionário cadastrado com o mesmo!");
        }
        // Verifica se já existe um funcionário cadastrado com o rg informado
        if (this.funcionarioRepository.buscarFuncionarioPeloRg(funcionarioDTO.getRg()) != null) {
            erros.add("- Você não pode cadastrar um funcionário com esse rg pois já existe um funcionário cadastrado com o mesmo!");
        }
        // Verifica se já existe um funcionário cadastrado com o login informado
        if (this.funcionarioRepository.buscarFuncionarioPeloLogin(funcionarioDTO.getLogin()) != null) {
            erros.add("- Você não pode cadastrar um funcionário com esse login pois já existe um funcionário cadastrado com o mesmo!");
        }
        // Verifica se já existe um funcionário cadastrado com a senha informada
        if (this.funcionarioRepository.buscarFuncionarioPelaSenha(funcionarioDTO.getSenha()) != null) {
            erros.add("- Você não pode cadastrar um funcionário com essa senha pois já existe um funcionário cadastrado com a mesma!");
        }
        // Caso a lista de erros possua algum elemento, lançar uma exceção com as mensagens de erro
        if (erros.size() > 0) {
            String errosMensagem = "";
            for (String erro : erros) {
                errosMensagem += ("\n" + erro);
            }
            // Lançando a exceção com as mensagens de erro
            throw new RuntimeException(errosMensagem);
        }
        Funcionario funcionario = new ConverterFuncionarioDTOEmFuncionario()
                .converter(funcionarioDTO);
        funcionario = this.funcionarioRepository.save(funcionario);
        if (funcionario == null) {
            throw new RuntimeException("Ocorreu um erro ao tentar-se cadastrar o funcionário!");
        }
        funcionarioDTO.setId(funcionario.getId());
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }
}
