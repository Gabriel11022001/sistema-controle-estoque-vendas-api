package br.com.gabriel.sistemacontroleestoquevendas.controllers;

import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioDTO;
import br.com.gabriel.sistemacontroleestoquevendas.dtos.FuncionarioParaLoginDTO;
import br.com.gabriel.sistemacontroleestoquevendas.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity cadastrarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        return this.funcionarioService.cadastrarFuncionario(funcionarioDTO);
    }
    @GetMapping
    public ResponseEntity buscarTodosFuncionarios() {
        return this.funcionarioService.buscarTodosFuncionarios();
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity buscarFuncionarioPeloId(@Valid @PathVariable("id") Integer id) {
        return this.funcionarioService.buscarFuncionarioPeloId(id);
    }
    @GetMapping(value = "/buscar-pelo-nome/{nome}")
    public ResponseEntity buscarFuncionariosQueContemNome(@Valid @PathVariable("nome") String nome) {
        return this.funcionarioService.buscarFuncionarioQueContemNome(nome);
    }
    @GetMapping(value = "/buscar-pelo-cpf/{cpf}")
    public ResponseEntity buscarFuncionarioPeloCpf(@Valid @PathVariable("cpf") String cpf) {
        return this.funcionarioService.buscarFuncionarioPeloCpf(cpf);
    }
    @GetMapping(value = "/buscar-pelo-rg/{rg}")
    public ResponseEntity buscarFuncionarioPeloRg(@Valid @PathVariable("rg") String rg) {
        return this.funcionarioService
                .buscarFuncionarioPeloRg(rg);
    }
    @PutMapping
    public ResponseEntity editarFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        return this.funcionarioService.editarFuncionario(funcionarioDTO);
    }
    @PostMapping(value = "/buscar-funcionario-pelo-login-senha")
    public ResponseEntity buscarFuncionarioPeloLoginESenha(@Valid @RequestBody FuncionarioParaLoginDTO funcionarioParaLoginDTO) {
        return this.funcionarioService.buscarFuncionarioPeloLoginESenha(
                funcionarioParaLoginDTO.getLogin(),
                funcionarioParaLoginDTO.getSenha()
        );
    }
}
