package com.r2csistemas.escolajj.orm;

import com.r2csistemas.escolajj.dto.EmpresaDto;
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
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "escola")
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "escolaCodigo")
    private Integer escolaCodigo;

    @Temporal(TemporalType.DATE)
    @Column(name = "escolaDataInicio")
    private Date escolaDataInicio;

    @Column(name = "escolaNome")
    private String escolaNome;

    @Column(name = "escolaEndereco")
    private String escolaEndereco;

    @Column(name = "escolaTelefone")
    private String escolaTelefone;

    @Column(name = "escolaBairro")
    private String escolaBairro;

    @Column(name = "escolaCidade")
    private String escolaCidade;

    @Column(name = "escolaUF")
    private String escolaUF;

    @ManyToOne(optional = true)
    @JoinColumn(name = "escolaResponsavel", referencedColumnName = "proCodigo")
    private Profissional escolaResponsavel;

    public Escola() {
    }

    public Escola(EmpresaDto dto) {
        this.escolaNome = dto.nome();
        this.escolaEndereco = dto.endereco();
        this.escolaTelefone = dto.telefone();
        this.escolaBairro = dto.bairro();
        this.escolaCidade = dto.cidade();
        this.escolaUF = dto.uf();
        this.escolaResponsavel= new Profissional(dto.responsavel().codigo());
        this.escolaDataInicio= dto.data_inicio();
    }

    public Date getEscolaDataInicio() {
        return escolaDataInicio;
    }

    public void setEscolaDataInicio(Date escolaDataInicio) {
        this.escolaDataInicio = escolaDataInicio;
    }

    public Integer getEscolaCodigo() {
        return escolaCodigo;
    }

    public void setEscolaCodigo(Integer escolaCodigo) {
        this.escolaCodigo = escolaCodigo;
    }

    public String getEscolaNome() {
        return escolaNome;
    }

    public void setEscolaNome(String escolaNome) {
        this.escolaNome = escolaNome;
    }

    public String getEscolaEndereco() {
        return escolaEndereco;
    }

    public void setEscolaEndereco(String escolaEndereco) {
        this.escolaEndereco = escolaEndereco;
    }

    public String getEscolaTelefone() {
        return escolaTelefone;
    }

    public void setEscolaTelefone(String escolaTelefone) {
        this.escolaTelefone = escolaTelefone;
    }

    public String getEscolaBairro() {
        return escolaBairro;
    }

    public void setEscolaBairro(String escolaBairro) {
        this.escolaBairro = escolaBairro;
    }

    public String getEscolaCidade() {
        return escolaCidade;
    }

    public void setEscolaCidade(String escolaCidade) {
        this.escolaCidade = escolaCidade;
    }

    public String getEscolaUF() {
        return escolaUF;
    }

    public void setEscolaUF(String escolaUF) {
        this.escolaUF = escolaUF;
    }

    public Profissional getEscolaResponsavel() {
        return escolaResponsavel;
    }

    public void setEscolaResponsavel(Profissional escolaResponsavel) {
        this.escolaResponsavel = escolaResponsavel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.escolaCodigo;
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
        final Escola other = (Escola) obj;
        if (this.escolaCodigo != other.escolaCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Escola{" +
                "escolaCodigo=" + escolaCodigo +
                ", escolaNome='" + escolaNome + '\'' +
                ", escolaCidade='" + escolaCidade + '\'' +
                '}';
    }
}
