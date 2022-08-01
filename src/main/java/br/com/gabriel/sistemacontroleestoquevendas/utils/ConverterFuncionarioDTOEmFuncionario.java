package br.com.gabriel.sistemacontroleestoquevendas.utils;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;

public class ConverterFuncionarioDTOEmFuncionario implements IConverteDTOEmEntidade<FuncionarioDTO, Funcionario> {

    @Override
    public Funcionario converter(FuncionarioDTO dto) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setLogin(dto.getLogin());
        funcionario.setSenha(dto.getSenha());
        funcionario.setNivelAcesso(dto.getNivelAcesso());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setCpf(dto.getCpf());
        funcionario.setRg(dto.getRg());
        funcionario.setDataNascimento(dto.getDataNascimento());
        funcionario.setSexo(dto.getSexo());
        funcionario.setStatus(dto.getStatus());
        funcionario.setBairro(dto.getBairro());
        funcionario.setRua(dto.getRua());
        funcionario.setUf(dto.getUf());
        funcionario.setCep(dto.getCep());
        funcionario.setNumeroResidencia(dto.getNumeroResidencia());
        funcionario.setComplemento(dto.getComplemento());
        funcionario.setCidade(dto.getCidade());
        return funcionario;
    }
}
