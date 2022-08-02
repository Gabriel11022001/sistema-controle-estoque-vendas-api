package br.com.gabriel.sistemacontroleestoquevendas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioParaLoginDTO {

    @NotEmpty(message = "O login é um campo obrigatório!")
    private String login;
    @NotEmpty(message = "A senha é um campo obrigatório!")
    @Length(min = 5, message = "A seha precisa possuir no mínimo cinco caracteres!")
    private String senha;
}
