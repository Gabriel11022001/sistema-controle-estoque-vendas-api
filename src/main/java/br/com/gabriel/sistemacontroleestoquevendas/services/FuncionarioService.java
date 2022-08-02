package br.com.gabriel.sistemacontroleestoquevendas.services;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.FuncionarioRepository;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverteFuncionarioEmFuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverterFuncionarioDTOEmFuncionario;
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
    public ResponseEntity buscarTodosFuncionarios(HttpSession sessao) {
        if (sessao.getAttribute("usuario_logado") == null) {
            throw new RuntimeException("Você precisar estar logado para buscar todos os funcionários!");
        }
        FuncionarioDTO funcionarioLogado = (FuncionarioDTO) sessao.getAttribute("usuario_logado");
        if (funcionarioLogado.getNivelAcesso() == 2) {
            throw new RuntimeException("Você não possui acesso a listagem dos dados de todos os funcionários da empresa!");
        }
        List<Funcionario> funcionarios = this.funcionarioRepository.findAll();
        if (funcionarios.size() == 0) {
            return new ResponseEntity(new ArrayList(), HttpStatus.OK);
        }
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO()
                    .converter(funcionario);
            funcionariosDTO.add(funcionarioDTO);
        }
        return new ResponseEntity(funcionariosDTO, HttpStatus.OK);
    }
}
