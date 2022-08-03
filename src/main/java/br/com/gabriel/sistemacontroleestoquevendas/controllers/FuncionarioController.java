package br.com.gabriel.sistemacontroleestoquevendas.controllers;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO, HttpSession sessao) {
        return this.funcionarioService.cadastrarFuncionario(funcionarioDTO, sessao);
    }
    @GetMapping
    public ResponseEntity buscarTodosFuncionarios(HttpSession sessao) {
        return this.funcionarioService.buscarTodosFuncionarios(sessao);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity buscarFuncionarioPeloId(@Valid @PathVariable("id") Integer id, HttpSession sessao) {
        return this.funcionarioService.buscarFuncionarioPeloId(id, sessao);
    }
    @GetMapping(value = "/buscar-pelo-nome/{nome}")
    public ResponseEntity buscarFuncionariosQueContemNome(@Valid @PathVariable("nome") String nome, HttpSession sessao) {
        return this.funcionarioService.buscarFuncionarioQueContemNome(nome, sessao);
    }
    @GetMapping(value = "/buscar-pelo-cpf/{cpf}")
    public ResponseEntity buscarFuncionarioPeloCpf(@Valid @PathVariable("cpf") String cpf, HttpSession sessao) {
        return this.funcionarioService.buscarFuncionarioPeloCpf(cpf, sessao);
    }
    @GetMapping(value = "/buscar-pelo-rg/{rg}")
    public ResponseEntity buscarFuncionarioPeloRg(@Valid @PathVariable("rg") String rg, HttpSession sessao) {
        return this.funcionarioService
                .buscarFuncionarioPeloRg(rg, sessao);
    }
}
