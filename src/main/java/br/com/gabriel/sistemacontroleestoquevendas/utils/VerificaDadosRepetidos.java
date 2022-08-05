package br.com.gabriel.sistemacontroleestoquevendas.utils;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.FuncionarioRepository;

import java.util.List;

public class VerificaDadosRepetidos {

    private FuncionarioRepository funcionarioRepository;

    public VerificaDadosRepetidos(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    public void verificarDadosFuncionario(FuncionarioDTO funcionarioDTO, List<String> erros) {
        this.verificarSeJaExisteFuncionarioCadastradoComEmailInformado(
                funcionarioDTO.getEmail(),
                erros
        );
        this.verificarSeJaExisteFuncionarioCadastradoComRgInformado(
                funcionarioDTO.getRg(),
                erros
        );
        this.verificarSeJaExisteFuncionarioCadastradoComCpfInformado(
                funcionarioDTO.getCpf(),
                erros
        );
        this.verificarSeJaExisteFuncionarioCadastradoComLoginInformado(
                funcionarioDTO.getLogin(),
                erros
        );
        this.verificarSeJaExisteFuncionarioCadastradoComSenhaInformada(
                funcionarioDTO.getSenha(),
                erros
        );
    }
    private void verificarSeJaExisteFuncionarioCadastradoComEmailInformado(String email, List<String> erros) {

    }
    private void verificarSeJaExisteFuncionarioCadastradoComCpfInformado(String cpf, List<String> erros) {

    }
    private void verificarSeJaExisteFuncionarioCadastradoComRgInformado(String rg, List<String> erros) {

    }
    private void verificarSeJaExisteFuncionarioCadastradoComLoginInformado(String login, List<String> erros) {

    }
    private void verificarSeJaExisteFuncionarioCadastradoComSenhaInformada(String senha, List<String> erros) {

    }
}
