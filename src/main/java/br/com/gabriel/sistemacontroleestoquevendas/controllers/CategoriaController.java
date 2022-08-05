package br.com.gabriel.sistemacontroleestoquevendas.controllers;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.CategoriaProdutoDTO;
import br.com.gabriel.sistemacontroleestoquevendas.repositories.CategoriaProdutoRepository;
import br.com.gabriel.sistemacontroleestoquevendas.services.CategoriaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaProdutoService categoriaProdutoService;

    @GetMapping
    public ResponseEntity buscarTodasAsCategorias() {
        return this.categoriaProdutoService.buscarTodasCategorias();
    }
    @PostMapping
    public ResponseEntity cadastrarCategoria(@Valid @RequestBody CategoriaProdutoDTO categoriaProdutoDTO) {
        return this.categoriaProdutoService.cadastrarCategoria(categoriaProdutoDTO);
    }
}
