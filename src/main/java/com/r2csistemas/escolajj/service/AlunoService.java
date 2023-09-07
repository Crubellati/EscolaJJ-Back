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
        if (dados.nome() != null) aluno.setAlunoNome(dados.nome());
        if (dados.celular() != null) aluno.setAlunoCelular1(dados.celular());
        if (dados.celular2() != null) aluno.setAlunoCelular2(dados.celular2());
        if (dados.rg() != null) aluno.setAlunoRG(dados.rg());
        if (dados.cpf() != null) aluno.setAlunoCPF(dados.cpf());
        if (dados.endereco() != null) aluno.setAlunoEndereco(dados.endereco());
        if (dados.bairro() != null) aluno.setAlunoBairro(dados.bairro());
        if (dados.complemento() != null) aluno.setAlunoComplemento(dados.complemento());
        if (dados.cidade() != null) aluno.setAlunoCidade(dados.cidade());
        if (dados.uf() != null) aluno.setAlunoUF(dados.uf());
        if (dados.data_cadastro() != null) aluno.setAlunoDataCadastro(Utils.convertLocalDateToDate(dados.data_cadastro()));
        if (dados.data_nasc() != null) aluno.setAlunoDataNasc(Utils.convertLocalDateToDate(dados.data_nasc()));

        //nao precisa repositorio.save pois estando dentro de uma anotação transaction a JPA detecta
        //alteração e ja commita as alterações no banco automaticamente
        //https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java/task/115969 - minuto 9
    }
}
