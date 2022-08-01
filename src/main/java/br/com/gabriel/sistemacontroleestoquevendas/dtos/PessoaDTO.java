package br.com.gabriel.sistemacontroleestoquevendas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String sexo;
    private Boolean status;
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private String numeroResidencia;
    private String complemento;
    private String uf;
}
