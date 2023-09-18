package com.r2csistemas.escolajj.dto;

import com.r2csistemas.escolajj.orm.Aluno;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record AlunoDtoForm(

        Integer codigo,
        @NotBlank
        String nome,
//        @Email
//        String email,
//        @Pattern(regexp = "\\d{8}")
//        String cep,
        String endereco,
        String complemento,
        String bairro,
        @NotBlank
        String cidade,
        String uf,
        String celular,
        String celular2,
        String status,
        Date data_cadastro,
        Date data_nasc,
        String cpf,
        String rg,
        String nomeResponsavel,
        String celResponsavel
) {

    public AlunoDtoForm(Aluno aluno) {
        this(aluno.getAlunoCodigo(),
                aluno.getAlunoNome(),
                aluno.getAlunoEndereco(),
                aluno.getAlunoComplemento(),
                aluno.getAlunoBairro(),
                aluno.getAlunoCidade(),
                aluno.getAlunoUF(),
                aluno.getAlunoCelular1(),
                aluno.getAlunoCelular2(),
                aluno.getAlunoStatus(),
                aluno.getAlunoDataCadastro(),
                aluno.getAlunoDataNasc(),
                aluno.getAlunoCPF(),
                aluno.getAlunoRG(),
                aluno.getAlunoNomeResponsavel(),
                aluno.getAlunoCelularResponsavel()
        );
    }
}


