package br.com.gabriel.sistemacontroleestoquevendas.services;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.FuncionarioRepository;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverteFuncionarioEmFuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverterFuncionarioDTOEmFuncionario;
import br.com.gabriel.sistemacontroleestoquevendas.utils.VerificaDadosRepetidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public ResponseEntity cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {

        List<String> erros = new ArrayList<>();
        // Verificar foram informados dados repetidos para o funcionário mas que precisam ser únicos
        VerificaDadosRepetidos verificaDadosRepetidos = new VerificaDadosRepetidos(this.funcionarioRepository);
        verificaDadosRepetidos.verificarDadosFuncionario(funcionarioDTO, erros);
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
    public ResponseEntity buscarTodosFuncionarios() {

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
    public ResponseEntity buscarFuncionarioPeloId(
            @NotNull(message = "O id não pode ser nulo!")
            @Min(value = 1, message = "O id não deve ser menor que 1!")
            Integer id
    ) {

        Funcionario funcionario = this.funcionarioRepository.findById(id)
                .orElse(null);
        if (funcionario == null) {
            return new ResponseEntity("Não existe um funcionário cadastrado no banco de dados com esse id!", HttpStatus.NOT_FOUND);
        }
        FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO()
                .converter(funcionario);
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }
    public ResponseEntity buscarFuncionarioQueContemNome(
            @NotEmpty(message = "Informe o nome do cliente!")
            String nome
    ) {
        List<Funcionario> funcionarios = this.funcionarioRepository.buscarFuncionariosQueContemNome(nome);
        if (funcionarios.size() == 0) {
            return new ResponseEntity(new ArrayList(), HttpStatus.OK);
        }
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        funcionarios.forEach((f) -> {
            FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO()
                    .converter(f);
            funcionariosDTO.add(funcionarioDTO);
        });
        return new ResponseEntity(funcionariosDTO, HttpStatus.OK);
    }
    public ResponseEntity buscarFuncionarioPeloCpf(
            @NotEmpty(message = "Imforme o cpf do funcionário!")
            String cpf
    ) {

        Funcionario funcionario = this.funcionarioRepository.buscarFuncionarioPeloCpf(cpf);
        if (funcionario == null) {
            return new ResponseEntity("Não existe um funcionário cadastrado no banco de dados com esse cpf!", HttpStatus.NOT_FOUND);
        }
        FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO()
                .converter(funcionario);
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }

    public ResponseEntity buscarFuncionarioPeloRg(
            @NotEmpty(message = "Informe o rg do funcionário!")
            String rg
    ) {

        Funcionario funcionario = this.funcionarioRepository
                .buscarFuncionarioPeloRg(rg);
        if (funcionario == null) {
            return new ResponseEntity("Não existe um funcionário cadastrado no banco de dados com esse rg!", HttpStatus.NOT_FOUND);
        }
        FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO()
                .converter(funcionario);
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }
    public ResponseEntity editarFuncionario(FuncionarioDTO funcionarioDTO) {

        List<String> erros = new ArrayList<>();
        // Verificar foram informados dados repetidos para o funcionário mas que precisam ser únicos
        VerificaDadosRepetidos verificaDadosRepetidos = new VerificaDadosRepetidos(this.funcionarioRepository);
        verificaDadosRepetidos.verificarDadosFuncionario(funcionarioDTO, erros);
        // Caso a lista de erros possua algum elemento, lançar uma exceção com as mensagens de erro
        if (erros.size() > 0) {
            String errosMensagem = "";
            for (String erro : erros) {
                errosMensagem += ("\n" + erro);
            }
            // Lançando a exceção com as mensagens de erro
            throw new RuntimeException(errosMensagem);
        }
        Funcionario funcionarioEditar = this.funcionarioRepository
                .findById(funcionarioDTO.getId())
                .orElse(null);
        if (funcionarioEditar == null) {
            return new ResponseEntity("Não existe um funcionário cadastrado no banco de dados com esse id!", HttpStatus.NOT_FOUND);
        }
        funcionarioEditar = new ConverterFuncionarioDTOEmFuncionario()
                .converter(funcionarioDTO);
        funcionarioEditar = this.funcionarioRepository.save(funcionarioEditar);
        if (funcionarioEditar == null) {
            throw new RuntimeException("Ocorreu um erro ao tentar-se atualizar os dados do funcionário em questão!");
        }
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }
    public ResponseEntity buscarFuncionarioPeloLoginESenha(String login, String senha) {

        Funcionario funcionario = this.funcionarioRepository.buscarFuncionarioPeloLoginESenha(login, senha);
        if (funcionario == null) {
            return new ResponseEntity("Login ou senha inválidos!", HttpStatus.NOT_FOUND);
        }
        FuncionarioDTO funcionarioDTO = new ConverteFuncionarioEmFuncionarioDTO().converter(funcionario);
        return new ResponseEntity(funcionarioDTO, HttpStatus.OK);
    }
}
