package com.r2csistemas.escolajj.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AlunoDtoForm(

        Integer codigo,

        @NotBlank
        String nome,

        @NotBlank
        String cidade,

//        @Email
//        String email,

//        @Pattern(regexp = "\\d{8}")
//        String cep,

        String endereco,
        String uf,

        String cpf,

        String celular,

        String status,

        LocalDate data_cadastro,

        LocalDate data_nasc,

        String celular2,

        String rg,

        String complemento,

        String bairro

) {

}


