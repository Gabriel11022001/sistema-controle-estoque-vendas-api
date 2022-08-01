package br.com.gabriel.sistemacontroleestoquevendas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {

    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false, unique = true)
    private String senha;
    @Column(nullable = false)
    private int nivelAcesso;
}
