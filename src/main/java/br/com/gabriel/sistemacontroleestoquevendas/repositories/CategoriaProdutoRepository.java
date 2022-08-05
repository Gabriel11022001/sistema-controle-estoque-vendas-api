package br.com.gabriel.sistemacontroleestoquevendas.repositories;

import br.com.gabriel.sistemacontroleestoquevendas.models.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer> {
}
