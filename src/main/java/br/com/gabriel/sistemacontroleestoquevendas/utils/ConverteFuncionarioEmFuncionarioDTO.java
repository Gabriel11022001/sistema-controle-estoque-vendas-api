package br.com.gabriel.sistemacontroleestoquevendas.utils;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;

public class ConverteFuncionarioEmFuncionarioDTO implements IConverteEntidadeEmDTO<Funcionario, FuncionarioDTO> {

    @Override
    public FuncionarioDTO converter(Funcionario entidade) {

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(entidade.getId());
        funcionarioDTO.setNome(entidade.getNome());
        funcionarioDTO.setEmail(entidade.getEmail());
        funcionarioDTO.setNivelAcesso(entidade.getNivelAcesso());
        funcionarioDTO.setTelefone(entidade.getTelefone());
        funcionarioDTO.setNivelAcesso(entidade.getNivelAcesso());
        funcionarioDTO.setCpf(entidade.getCpf());
        funcionarioDTO.setRg(entidade.getRg());
        funcionarioDTO.setRua(entidade.getRua());
        funcionarioDTO.setBairro(entidade.getBairro());
        funcionarioDTO.setComplemento(entidade.getComplemento());
        funcionarioDTO.setUf(entidade.getUf());
        funcionarioDTO.setNumeroResidencia(entidade.getNumeroResidencia());
        funcionarioDTO.setSexo(entidade.getSexo());
        funcionarioDTO.setStatus(entidade.getStatus());
        funcionarioDTO.setCidade(entidade.getCidade());
        funcionarioDTO.setDataNascimento(entidade.getDataNascimento());
        funcionarioDTO.setCep(entidade.getCep());
        return funcionarioDTO;
    }
}
