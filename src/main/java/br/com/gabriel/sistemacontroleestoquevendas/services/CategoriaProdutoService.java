package br.com.gabriel.sistemacontroleestoquevendas.services;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.CategoriaProdutoDTO;
import br.com.gabriel.sistemacontroleestoquevendas.models.CategoriaProduto;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.CategoriaProdutoRepository;
import br.com.gabriel.sistemacontroleestoquevendas.utils.ConverteCategoriaProdutoDTOEmCategoriaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    public ResponseEntity cadastrarCategoria(CategoriaProdutoDTO categoriaProdutoDTO) {

        CategoriaProduto categoriaProduto = new ConverteCategoriaProdutoDTOEmCategoriaProduto()
                .converter(categoriaProdutoDTO);
        categoriaProduto = this.categoriaProdutoRepository.save(categoriaProduto);
        if (categoriaProduto == null) {
            throw new RuntimeException("Ocorreu um erro ao tentar-se cadastrar a categoria do produto!");
        }
        categoriaProdutoDTO.setId(categoriaProduto.getId());
        return new ResponseEntity(categoriaProdutoDTO, HttpStatus.CREATED);
    }
    public ResponseEntity buscarTodasCategorias() {

        List<CategoriaProduto> categorias = this.categoriaProdutoRepository
                .findAll();
        return new ResponseEntity(categorias, HttpStatus.OK);
    }
}
