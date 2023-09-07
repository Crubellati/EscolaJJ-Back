package com.r2csistemas.escolajj.service;

import com.r2csistemas.escolajj.dto.ProfissionalDto;
import com.r2csistemas.escolajj.orm.Profissional;
import com.r2csistemas.escolajj.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;
 
    public void atualizarDados(Profissional profissional, ProfissionalDto dados) {
        if (dados.nome() != null) profissional.setProNome(dados.nome());
    }

}
