package com.r2csistemas.escolajj.dto;

import com.r2csistemas.escolajj.orm.Aluno;

import java.util.Date;

public record AlunoDtoDetalhes(
        Integer codigo,
        byte[] foto,
        String nome,
        String endereco,
        String cpf,
        String celular,
        String bairro,
        String cidade,
        String status,
        String complemento,
        String uf,
        String rg,
        String celular2,
        Date data_cadastro,
        Date data_nasc) {

    public AlunoDtoDetalhes(Aluno aluno) {
        this(aluno.getAlunoCodigo(),
                aluno.getFoto(),
                aluno.getAlunoNome(),
                aluno.getAlunoEndereco(),
                aluno.getAlunoCPF(),
                aluno.getAlunoCelular1(),
                aluno.getAlunoBairro(),
                aluno.getAlunoCidade(),
                aluno.getAlunoStatus(),
                aluno.getAlunoComplemento(),
                aluno.getAlunoUF(),
                aluno.getAlunoRG(),
                aluno.getAlunoCelular2(),
                aluno.getAlunoDataCadastro(),
                aluno.getAlunoDataNasc()
        );
    }
}
