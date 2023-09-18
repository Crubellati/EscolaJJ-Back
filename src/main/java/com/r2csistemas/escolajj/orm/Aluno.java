package com.r2csistemas.escolajj.orm;

import com.r2csistemas.escolajj.dto.AlunoDtoForm;
import com.r2csistemas.escolajj.util.Utils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alunoCodigo")
    private Integer alunoCodigo;

    @Column(name = "foto")
    private byte[] foto;

    @ManyToOne(optional = true)
    @JoinColumn(name = "alunoEscola", referencedColumnName = "escolaCodigo")
    private Escola alunoEscola;

    @Temporal(TemporalType.DATE)
    @Column(name = "alunoDataCadastro")
    private Date alunoDataCadastro;

    @Column(name = "alunoNome")
    private String alunoNome;

    @Column(name = "alunoStatus")
    private String alunoStatus;

    @Column(name = "alunoCelular1")
    private String alunoCelular1;

    @Column(name = "alunoCelular2")
    private String alunoCelular2;

    @Column(name = "alunoEndereco")
    private String alunoEndereco;

    @Column(name = "alunoComplemento")
    private String alunoComplemento;

    @Column(name = "alunoBairro")
    private String alunoBairro;

    @Column(name = "alunoCidade")
    private String alunoCidade;

    @Column(name = "alunoUF")
    private String alunoUF;

    @Column(name = "alunoCPF")
    private String alunoCPF;

    @Column(name = "alunoRG")
    private String alunoRG;

    @Column(name = "alunoExcluido")
    private Boolean alunoExcluido;

    @Column(name = "alunoNomeResponsavel")
    private String alunoNomeResponsavel;

    @Column(name = "alunoCelularResponsavel")
    private String alunoCelularResponsavel;

    @OneToMany(mappedBy = "matriculaAluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Matricula> matriculaList;

    @Temporal(TemporalType.DATE)
    @Column(name = "alunoDataNasc")
    private Date alunoDataNasc;

    @Transient
    private Boolean checkDiaFrequencia;

    public Aluno() {
    }

    public Aluno(AlunoDtoForm dto) {
        this.alunoNome = dto.nome();
        this.alunoEndereco = dto.endereco();
        this.alunoBairro = dto.bairro();
        this.alunoCidade = dto.cidade();
        this.alunoComplemento = dto.complemento();
        this.alunoUF = dto.uf();
        this.alunoRG = dto.rg();
        this.alunoCPF = dto.cpf();
        this.alunoCelular1 = dto.celular();
        this.alunoCelular2 = dto.celular2();
        this.alunoStatus = dto.status();
        this.alunoDataCadastro = dto.data_cadastro();
        this.alunoDataNasc = dto.data_nasc();
        this.alunoNomeResponsavel = dto.nomeResponsavel();
        this.alunoCelularResponsavel = dto.celResponsavel();
        this.alunoEscola = new Escola(1);
        this.alunoExcluido = false;

    }

    public Boolean getCheckDiaFrequencia() {
        return checkDiaFrequencia;
    }

    public void setCheckDiaFrequencia(Boolean checkDiaFrequencia) {
        this.checkDiaFrequencia = checkDiaFrequencia;
    }

    public List<Matricula> getMatriculaList() {
        if (matriculaList == null) matriculaList = new ArrayList<>();
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public Integer getAlunoCodigo() {
        return alunoCodigo;
    }

    public Integer getIdade() {
        int idade = 0;
        LocalDate dataNasc = null;
        try {
            if (alunoDataNasc != null) {
                LocalDate hoje = LocalDate.now();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(alunoDataNasc);
                dataNasc = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                idade = Period.between(dataNasc, hoje).getYears();
            }
        } catch (Exception e) {
            System.out.println("Data de nascimento incorreta: " + alunoDataNasc);
        }
        return idade;
    }

    public void setAlunoCodigo(Integer alunoCodigo) {
        this.alunoCodigo = alunoCodigo;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public String getAlunoCelular1() {
        return alunoCelular1;
    }

    public void setAlunoCelular1(String alunoCelular1) {
        this.alunoCelular1 = alunoCelular1;
    }

    public String getAlunoCelular2() {
        return alunoCelular2;
    }

    public void setAlunoCelular2(String alunoCelular2) {
        this.alunoCelular2 = alunoCelular2;
    }

    public String getAlunoEndereco() {
        return alunoEndereco;
    }

    public void setAlunoEndereco(String alunoEndereco) {
        this.alunoEndereco = alunoEndereco;
    }

    public String getAlunoBairro() {
        return alunoBairro;
    }

    public void setAlunoBairro(String alunoBairro) {
        this.alunoBairro = alunoBairro;
    }

    public String getAlunoCidade() {
        return alunoCidade;
    }

    public void setAlunoCidade(String alunoCidade) {
        this.alunoCidade = alunoCidade;
    }

    public String getAlunoUF() {
        return alunoUF;
    }

    public void setAlunoUF(String alunoUF) {
        this.alunoUF = alunoUF;
    }

    public String getAlunoCPF() {
        return alunoCPF;
    }

    public void setAlunoCPF(String alunoCPF) {
        this.alunoCPF = alunoCPF;
    }

    public String getAlunoRG() {
        return alunoRG;
    }

    public void setAlunoRG(String alunoRG) {
        this.alunoRG = alunoRG;
    }

    public Date getAlunoDataNasc() {
        return alunoDataNasc;
    }

    public void setAlunoDataNasc(Date alunoDataNasc) {
        this.alunoDataNasc = alunoDataNasc;
    }

    public String getAlunoStatus() {
        return alunoStatus;
    }

    public void setAlunoStatus(String alunoStatus) {
        this.alunoStatus = alunoStatus;
    }

    public String getAlunoComplemento() {
        return alunoComplemento;
    }

    public void setAlunoComplemento(String alunoComplemento) {
        this.alunoComplemento = alunoComplemento;
    }

    public Date getAlunoDataCadastro() {
        return alunoDataCadastro;
    }

    public void setAlunoDataCadastro(Date alunoDataCadastro) {
        this.alunoDataCadastro = alunoDataCadastro;
    }

    public String getAlunoNomeResponsavel() {
        return alunoNomeResponsavel;
    }

    public void setAlunoNomeResponsavel(String alunoNomeResponsavel) {
        this.alunoNomeResponsavel = alunoNomeResponsavel;
    }

    public String getAlunoCelularResponsavel() {
        return alunoCelularResponsavel;
    }

    public void setAlunoCelularResponsavel(String alunoCelularResponsavel) {
        this.alunoCelularResponsavel = alunoCelularResponsavel;
    }

    public Boolean getAlunoExcluido() {
        return alunoExcluido;
    }

    public void setAlunoExcluido(Boolean alunoExcluido) {
        this.alunoExcluido = alunoExcluido;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void populaMatriculas() { //// TODO: 09/11/2022 REMOVER ESSE MÉTODO DAQUI 
        if (alunoCodigo != null) {
            if (matriculaList == null)
                matriculaList = new ArrayList<>();
//            matriculaList = new MatriculaDAO().getMatriculasByAluno(alunoCodigo);
        }
    }

    public Escola getAlunoEscola() {
        return alunoEscola;
    }

    public void setAlunoEscola(Escola alunoEscola) {
        this.alunoEscola = alunoEscola;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "alunoCodigo=" + alunoCodigo +
                ", alunoNome='" + alunoNome + '\'' +
                ", alunoStatus='" + alunoStatus + '\'' +
                '}';
    }
}
