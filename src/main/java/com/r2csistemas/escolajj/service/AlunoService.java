package com.r2csistemas.escolajj.service;

import com.r2csistemas.escolajj.dto.AlunoDtoForm;
import com.r2csistemas.escolajj.orm.Aluno;
import com.r2csistemas.escolajj.repository.AlunoRepository;
import com.r2csistemas.escolajj.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarPorNome(String nome) {
        Pageable pageable = PageRequest.of(0, 5, Sort.unsorted());
        return alunoRepository.findByAlunoNome(nome, pageable);
    }

    public List<Aluno> buscarPorStatus(String status) {
        return alunoRepository.findByStatusCustom(status);
    }

    public List<Aluno> buscarPorBairro(String bairro) {
        return alunoRepository.findByBairroCustom(bairro);
    }

    public void atualizarDados(Aluno aluno, AlunoDtoForm dados) {
        aluno.setAlunoNome(dados.nome());
        aluno.setAlunoCelular1(dados.celular());
        aluno.setAlunoCelular2(dados.celular2());
        aluno.setAlunoRG(dados.rg());
        aluno.setAlunoCPF(dados.cpf());
        aluno.setAlunoEndereco(dados.endereco());
        aluno.setAlunoBairro(dados.bairro());
        aluno.setAlunoComplemento(dados.complemento());
        aluno.setAlunoCidade(dados.cidade());
        aluno.setAlunoUF(dados.uf());
        aluno.setAlunoDataCadastro(dados.data_cadastro());
        aluno.setAlunoDataNasc(dados.data_nasc());
        aluno.setAlunoNomeResponsavel(dados.nomeResponsavel());
        aluno.setAlunoCelularResponsavel(dados.celResponsavel());

        //nao precisa repositorio.save pois estando dentro de uma anotação transaction a JPA detecta
        //alteração e ja commita as alterações no banco automaticamente
        //https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java/task/115969 - minuto 9
    }
}
