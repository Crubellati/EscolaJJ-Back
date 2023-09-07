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
import jakarta.persistence.Transient;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "mensalidade")
public class Mensalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensalidadeCodigo")
    private Integer mensalidadeCodigo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "mensalidadeEscola", referencedColumnName = "escolaCodigo")
    private Escola mensalidadeEscola;

    @Temporal(TemporalType.DATE)
    @Column(name = "mensalidadeDataPagto")
    private Date mensalidadeDataPagto;

    @Column(name = "mensalidadeMes")
    private Integer mensalidadeMes;

    @Column(name = "mensalidadeAno")
    private Integer mensalidadeAno;

    @Column(name = "mensalidadePago")
    private Boolean mensalidadePago;

    @ManyToOne(optional = true)
    @JoinColumn(name = "mensalidadeAluno", referencedColumnName = "alunoCodigo")
    private Aluno mensalidadeAluno;

    @ManyToOne(optional = true)
    @JoinColumn(name = "mensalidadeProfissional", referencedColumnName = "proCodigo")
    private Profissional mensalidadeProfissional;

    @Transient
    private String chave;
    @Transient
    private Double valor;

    public Mensalidade() {
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Integer getMensalidadeCodigo() {
        return mensalidadeCodigo;
    }

    public void setMensalidadeCodigo(Integer mensalidadeCodigo) {
        this.mensalidadeCodigo = mensalidadeCodigo;
    }

    public Date getMensalidadeDataPagto() {
        return mensalidadeDataPagto;
    }

    public void setMensalidadeDataPagto(Date mensalidadeDataPagto) {
        this.mensalidadeDataPagto = mensalidadeDataPagto;
    }

    public Integer getMensalidadeMes() {
        return mensalidadeMes;
    }

    public void setMensalidadeMes(Integer mensalidadeMes) {
        this.mensalidadeMes = mensalidadeMes;
    }

    public Integer getMensalidadeAno() {
        if (mensalidadeAno == null) {
            mensalidadeAno = LocalDateTime.now().getYear();
        }
        return mensalidadeAno;
    }

    public void setMensalidadeAno(Integer mensalidadeAno) {
        this.mensalidadeAno = mensalidadeAno;
    }

    public Boolean getMensalidadePago() {
        return mensalidadePago;
    }

    public void setMensalidadePago(Boolean mensalidadePago) {
        this.mensalidadePago = mensalidadePago;
    }

    public Aluno getMensalidadeAluno() {
        return mensalidadeAluno;
    }

    public void setMensalidadeAluno(Aluno mensalidadeAluno) {
        this.mensalidadeAluno = mensalidadeAluno;
    }

    public Profissional getMensalidadeProfissional() {
        return mensalidadeProfissional;
    }

    public void setMensalidadeProfissional(Profissional mensalidadeProfissional) {
        this.mensalidadeProfissional = mensalidadeProfissional;
    }

    public Escola getMensalidadeEscola() {
        return mensalidadeEscola;
    }

    public void setMensalidadeEscola(Escola mensalidadeEscola) {
        this.mensalidadeEscola = mensalidadeEscola;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.mensalidadeCodigo;
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
        final Mensalidade other = (Mensalidade) obj;
        if (this.mensalidadeCodigo != other.mensalidadeCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return mensalidadeCodigo + "";
    }

}
