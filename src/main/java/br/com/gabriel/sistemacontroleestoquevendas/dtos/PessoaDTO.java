package br.com.gabriel.sistemacontroleestoquevendas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private int id;
    @NotEmpty(message = "O nome é um campo obrigatório!")
    @Length(min = 3, message = "O nome precisa ter pelo menos três caracteres!")
    private String nome;
    @NotEmpty(message = "O rg é um campo obrigatório!")
    private String rg;
    @NotEmpty(message = "O cpf é um campo obrigatório!")
    @CPF(message = "O formato do cpf informado é inválido!")
    private String cpf;
    @NotEmpty(message = "O e-mail é um campo obrigatório!")
    @Email(message = "O formato do e-mail informado é inválido!")
    private String email;
    @NotEmpty(message = "O telefone é um campo obrigatório!")
    private String telefone;
    @NotNull(message = "A data de nascimento é um campo obrigatório!")
    private LocalDate dataNascimento;
    @NotEmpty(message = "O sexo é um campo obrigatório!")
    private String sexo;
    @NotNull(message = "O status é um campo obrigatório!")
    private Boolean status;
    @NotEmpty(message = "A rua é um campo obrigatório!")
    private String rua;
    @NotEmpty(message = "O bairro é um campo obrigatório!")
    private String bairro;
    @NotEmpty(message = "A cidade é um campo obrigatório!")
    private String cidade;
    @NotEmpty(message = "O cep é um campo obrigatório!")
    @Length(min = 8, message = "O cep precisa possuir no mínimo oito caracteres!")
    private String cep;
    private String numeroResidencia;
    private String complemento;
    @NotEmpty(message = "A unidade federativa é um campo obrigatório!")
    @Length(min = 2, max = 2, message = "A unidade federativa precisa ter no mínimo 2 carecteres e no máximo 2 caracteres!")
    private String uf;
}
