package br.com.gabriel.sistemacontroleestoquevendas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String rg;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false)
    private Boolean status;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String rua;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String bairro;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String cidade;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = true)
    private String numeroResidencia;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String complemento;
    @Column(length = 2, nullable = true)
    private String uf;
}
