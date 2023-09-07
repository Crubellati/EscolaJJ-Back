package com.r2csistemas.escolajj.dto;

import com.r2csistemas.escolajj.orm.Profissional;
import jakarta.validation.constraints.NotBlank;

public record ProfissionalDto(
        Integer codigo,
        @NotBlank
        String nome) {

    public ProfissionalDto(Profissional profissional) {
        this(profissional.getProCodigo(),
                profissional.getProNome()
        );
    }
}
