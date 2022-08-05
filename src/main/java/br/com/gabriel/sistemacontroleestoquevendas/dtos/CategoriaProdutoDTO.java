package br.com.gabriel.sistemacontroleestoquevendas.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoDTO {

    private Integer id;
    @NotEmpty(message = "A descrição da categoria é um campo obrigatório!")
    @Length(min = 3, message = "A descrição da categoria precisa ter no mínimo 3 caracteres!")
    private String descricao;
    @NotNull(message = "O status da categoria é um campo obrigatório!")
    private Boolean status;
}
