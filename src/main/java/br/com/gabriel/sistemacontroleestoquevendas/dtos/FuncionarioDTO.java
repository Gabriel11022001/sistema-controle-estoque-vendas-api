package br.com.gabriel.sistemacontroleestoquevendas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO extends PessoaDTO {

    private String login;
    private String senha;
    private int nivelAcesso;
}
