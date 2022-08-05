package br.com.gabriel.sistemacontroleestoquevendas.utils;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.CategoriaProdutoDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.CategoriaProduto;

public class ConverteCategoriaProdutoDTOEmCategoriaProduto implements IConverteDTOEmEntidade<CategoriaProdutoDTO, CategoriaProduto> {

    @Override
    public CategoriaProduto converter(CategoriaProdutoDTO dto) {

        CategoriaProduto categoriaProduto = new CategoriaProduto();
        categoriaProduto.setId(dto.getId());
        categoriaProduto.setDescricao(dto.getDescricao());
        categoriaProduto.setStatus(dto.getStatus());
        return categoriaProduto;
    }
}

