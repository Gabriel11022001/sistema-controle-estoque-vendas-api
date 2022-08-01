package br.com.gabriel.sistemacontroleestoquevendas.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_clientes")
public class Cliente extends Pessoa {

    public Cliente() {
        super();
    }
}
