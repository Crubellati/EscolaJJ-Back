package com.r2csistemas.escolajj.repository;

import com.r2csistemas.escolajj.orm.Escola;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Escola, Integer> {

    List<Escola> findByEscolaNome(String nome, Pageable pageable);

    List<Escola> findByEscolaNomeContainsOrderByEscolaCodigoDesc(String nome);

//    exemplo de uso em jpql
//    @Query("SELECT a FROM Escola a WHERE a.EscolaStatus = :status")
//    List<Escola> findByStatusCustom(String status);

    //exemplo de uso em sql nativo
//    @Query(value = "SELECT * FROM Escola a WHERE a.EscolaBairro = :bairro", nativeQuery = true)
//    List<Escola> findByBairroCustom(String bairro);
}
