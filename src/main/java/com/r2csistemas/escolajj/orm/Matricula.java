package com.r2csistemas.escolajj.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matriculaCodigo")
    private Integer matriculaCodigo;

    @Temporal(TemporalType.DATE)
    @Column(name = "matriculaDataInicio")
    private Date matriculaDataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "matriculaDataFinal")
    private Date matriculaDataFinal;

    @Column(name = "matriculaObservacao")
    private String matriculaObservacao;

    @Column(name = "matriculaDiaVencimento")
    private Integer matriculaDiaVencimento;

    @Column(name = "matriculaValorMensalidade")
    private Double matriculaValorMensalidade;

    @ManyToOne(optional = true)
    @JoinColumn(name = "matriculaAluno", referencedColumnName = "alunoCodigo")
    private Aluno matriculaAluno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "matriculaEscola", referencedColumnName = "escolaCodigo")
    private Escola matriculaEscola;

    public Matricula() {
    }

    public Integer getMatriculaCodigo() {
        return matriculaCodigo;
    }

    public void setMatriculaCodigo(Integer matriculaCodigo) {
        this.matriculaCodigo = matriculaCodigo;
    }

    public Date getMatriculaDataInicio() {
        return matriculaDataInicio;
    }

    public void setMatriculaDataInicio(Date matriculaDataInicio) {
        this.matriculaDataInicio = matriculaDataInicio;
    }

    public Date getMatriculaDataFinal() {
        return matriculaDataFinal;
    }

    public void setMatriculaDataFinal(Date matriculaDataFinal) {
        this.matriculaDataFinal = matriculaDataFinal;
    }

    public String getMatriculaObservacao() {
        return matriculaObservacao;
    }

    public void setMatriculaObservacao(String matriculaObservacao) {
        this.matriculaObservacao = matriculaObservacao;
    }

    public Integer getMatriculaDiaVencimento() {
        return matriculaDiaVencimento;
    }

    public void setMatriculaDiaVencimento(Integer matriculaDiaVencimento) {
        this.matriculaDiaVencimento = matriculaDiaVencimento;
    }

    public Double getMatriculaValorMensalidade() {
        return matriculaValorMensalidade;
    }

    public void setMatriculaValorMensalidade(Double matriculaValorMensalidade) {
        this.matriculaValorMensalidade = matriculaValorMensalidade;
    }

    public Aluno getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Aluno matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public Escola getMatriculaEscola() {
        return matriculaEscola;
    }

    public void setMatriculaEscola(Escola matriculaEscola) {
        this.matriculaEscola = matriculaEscola;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.matriculaCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) obj;
        if (this.matriculaCodigo != other.matriculaCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return matriculaCodigo + "";
    }

}
