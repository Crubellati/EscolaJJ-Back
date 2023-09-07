package com.r2csistemas.escolajj.dto;

import com.r2csistemas.escolajj.orm.Escola;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record EmpresaDto(
        Integer codigo,
        @NotBlank
        String nome,
        String endereco,
        String telefone,
        String bairro,
        String cidade,
        String uf,
        ProfissionalDto responsavel,
        Date data_inicio) {

    public EmpresaDto(Escola escola) {
        this(escola.getEscolaCodigo(),
                escola.getEscolaNome(),
                escola.getEscolaEndereco(),
                escola.getEscolaTelefone(),
                escola.getEscolaBairro(),
                escola.getEscolaCidade(),
                escola.getEscolaUF(),
                (escola.getEscolaResponsavel() != null ? new ProfissionalDto(escola.getEscolaResponsavel()) : null),
                escola.getEscolaDataInicio()
        );
    }

}
