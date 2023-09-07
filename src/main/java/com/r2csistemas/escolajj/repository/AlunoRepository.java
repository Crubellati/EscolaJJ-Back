package com.r2csistemas.escolajj.repository;

import com.r2csistemas.escolajj.orm.Aluno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByAlunoNome(String nome, Pageable pageable);

    List<Aluno> findByAlunoNomeContainsOrderByAlunoCodigoDesc(String nome);

    //exemplo de uso em jpql
    @Query("SELECT a FROM Aluno a WHERE a.alunoStatus = :status")
    List<Aluno> findByStatusCustom(String status);

    //exemplo de uso em sql nativo
    @Query(value = "SELECT * FROM aluno a WHERE a.alunoBairro = :bairro", nativeQuery = true)
    List<Aluno> findByBairroCustom(String bairro);
}
