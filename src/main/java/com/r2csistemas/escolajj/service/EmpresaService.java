package com.r2csistemas.escolajj.service;

import com.r2csistemas.escolajj.dto.EmpresaDto;
import com.r2csistemas.escolajj.orm.Escola;
import com.r2csistemas.escolajj.orm.Profissional;
import com.r2csistemas.escolajj.repository.EmpresaRepository;
import com.r2csistemas.escolajj.repository.ProfissionalRepository;
import com.r2csistemas.escolajj.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public void atualizarDados(Escola escola, EmpresaDto dados) {
        if (dados.nome() != null) escola.setEscolaNome(dados.nome());
        if (dados.endereco() != null) escola.setEscolaEndereco(dados.endereco());
        if (dados.telefone() != null) escola.setEscolaTelefone(dados.telefone());
        if (dados.bairro() != null) escola.setEscolaBairro(dados.bairro());
        if (dados.cidade() != null) escola.setEscolaCidade(dados.cidade());
        if (dados.uf() != null) escola.setEscolaUF(dados.uf());
        verifyChangeResponsavel(escola, dados);
        if (dados.data_inicio() != null) escola.setEscolaDataInicio(dados.data_inicio());

        //nao precisa repositorio.save pois estando dentro de uma anotação transaction a JPA detecta
        //alteração e ja commita as alterações no banco automaticamente
        //https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java/task/115969 - minuto 9
    }

    private void verifyChangeResponsavel(Escola escola, EmpresaDto dados) {
        if (dados.responsavel() != null) {
//            Optional<Profissional> optionalProfissional = profissionalRepository.findByProCodigo(Integer.parseInt(dados.responsavel()));
//            if (optionalProfissional.isPresent()) {
//                escola.setEscolaResponsavel(optionalProfissional.get());
//            }
        }
    }
}
