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
public class FuncionarioDTO extends PessoaDTO {

    @NotEmpty(message = "O login é um campo obrigatório!")
    private String login;
    @NotEmpty(message = "A senha é um campo obrigatório!")
    @Length(min = 5, message = "A seha precisa possuir no mínimo cinco caracteres!")
    private String senha;
    @NotNull(message = "O nível de acesso do funcionário é um campo obrigatório!")
    @Min(value = 1, message = "O nível de acesso do funcionário não pode ser representado por um número menor que 1!")
    @Max(value = 2, message = "O nível de acesso do funcionário não pode ser representado por um número maior que 2!")
    private int nivelAcesso;
}
