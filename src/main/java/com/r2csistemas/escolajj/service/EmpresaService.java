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
         escola.setEscolaNome(dados.nome());
       escola.setEscolaEndereco(dados.endereco());
      escola.setEscolaTelefone(dados.telefone());
      escola.setEscolaBairro(dados.bairro());
       escola.setEscolaCidade(dados.cidade());
      escola.setEscolaUF(dados.uf());
        verifyChangeResponsavel(escola, dados);
      escola.setEscolaDataInicio(dados.data_inicio());

        //nao precisa repositorio.save pois estando dentro de uma anotação transaction a JPA detecta
        //alteração e ja commita as alterações no banco automaticamente
        //https://cursos.alura.com.br/course/spring-boot-3-desenvolva-api-rest-java/task/115969 - minuto 9
    }

    private void verifyChangeResponsavel(Escola escola, EmpresaDto dto) {
        if (dto.responsavel() != null) {
            Optional<Profissional> optionalProfissional = profissionalRepository.findByProCodigo(dto.responsavel().codigo());
            if (optionalProfissional.isPresent()) {
                escola.setEscolaResponsavel(optionalProfissional.get());
            }
        }
    }
}
