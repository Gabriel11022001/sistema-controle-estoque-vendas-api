package br.com.gabriel.sistemacontroleestoquevendas.repositories;

import br.com.gabriel.sistemacontroleestoquevendas.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("select f from Funcionario f where f.login = :login and f.senha = md5(:senha)")
    Funcionario buscarFuncionarioPeloLoginESenha(@Param("login") String login, @Param("senha") String senha);
    @Query("select f from Funcionario f where f.email = :email")
    Funcionario buscarFuncionarioPeloEmail(@Param("email") String email);
    @Query("select f from Funcionario f where f.cpf = :cpf")
    Funcionario buscarFuncionarioPeloCpf(@Param("cpf") String cpf);
    @Query("select f from Funcionario f where f.rg = :rg")
    Funcionario buscarFuncionarioPeloRg(@Param("rg") String rg);
    @Query("select f from Funcionario f where f.login = :login")
    Funcionario buscarFuncionarioPeloLogin(@Param("login") String login);
    @Query("select f from Funcionario f where f.senha = :senha")
    Funcionario buscarFuncionarioPelaSenha(@Param("senha") String senha);
    @Query("select f from Funcionario f where f.nome like %:nome%")
    List<Funcionario> buscarFuncionariosQueContemNome(@Param("nome") String nome);
}
