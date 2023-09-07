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
@Table(name = "frequencia")
public class Frequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frequenciaCodigo")
    private Integer frequenciaCodigo;


    @ManyToOne(optional = false)
    @JoinColumn(name = "frequenciaEscola", referencedColumnName = "escolaCodigo")
    private Escola frequenciaEscola;


    @Temporal(TemporalType.DATE)
    @Column(name = "frequenciaData")
    private Date frequenciaData;

    @ManyToOne(optional = false)
    @JoinColumn(name = "frequenciaAluno", referencedColumnName = "alunoCodigo")
    private Aluno frequenciaAluno;

    @Column(name = "frequenciaPresente")
    private Boolean frequenciaPresente;

    @Column(name = "frequenciaHora")
    private String frequenciaHora;

    @Column(name = "frequenciaLatitude")
    private String frequenciaLatitude;

    @Column(name = "frequenciaLongetude")
    private String frequenciaLongetude;


    public Frequencia() {
    }

    public String getFrequenciaLatitude() {
        return frequenciaLatitude;
    }

    public void setFrequenciaLatitude(String frequenciaLatitude) {
        this.frequenciaLatitude = frequenciaLatitude;
    }

    public String getFrequenciaLongetude() {
        return frequenciaLongetude;
    }

    public void setFrequenciaLongetude(String frequenciaLongetude) {
        this.frequenciaLongetude = frequenciaLongetude;
    }

    public Integer getFrequenciaCodigo() {
        return frequenciaCodigo;
    }

    public void setFrequenciaCodigo(Integer frequenciaCodigo) {
        this.frequenciaCodigo = frequenciaCodigo;
    }

    public Date getFrequenciaData() {
        return frequenciaData;
    }

    public void setFrequenciaData(Date frequenciaData) {
        this.frequenciaData = frequenciaData;
    }

    public Aluno getFrequenciaAluno() {
        return frequenciaAluno;
    }

    public void setFrequenciaAluno(Aluno frequenciaAluno) {
        this.frequenciaAluno = frequenciaAluno;
    }

    public Boolean getFrequenciaPresente() {
        return frequenciaPresente;
    }

    public void setFrequenciaPresente(Boolean frequenciaPresente) {
        this.frequenciaPresente = frequenciaPresente;
    }

    public String getFrequenciaHora() {
        return frequenciaHora;
    }

    public void setFrequenciaHora(String frequenciaHora) {
        this.frequenciaHora = frequenciaHora;
    }

    public Escola getFrequenciaEscola() {
        return frequenciaEscola;
    }

    public void setFrequenciaEscola(Escola frequenciaEscola) {
        this.frequenciaEscola = frequenciaEscola;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.frequenciaCodigo;
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
        final Frequencia other = (Frequencia) obj;
        if (this.frequenciaCodigo != other.frequenciaCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return frequenciaCodigo + "";
    }

}
