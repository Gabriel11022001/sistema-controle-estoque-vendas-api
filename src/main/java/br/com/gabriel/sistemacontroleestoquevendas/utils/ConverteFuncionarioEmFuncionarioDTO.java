package br.com.gabriel.sistemacontroleestoquevendas.utils;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;

public class ConverteFuncionarioEmFuncionarioDTO implements IConverteEntidadeEmDTO<Funcionario, FuncionarioDTO> {

    @Override
    public FuncionarioDTO converter(Funcionario entidade) {

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        return funcionarioDTO;
    }
}
