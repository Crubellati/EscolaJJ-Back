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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "profissional")
public class Profissional implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proCodigo")
    private Integer proCodigo;

    @Column(name = "proNome")
    private String proNome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profissionalEscola", referencedColumnName = "escolaCodigo")
    private Escola profissionalEscola;

    @Column(name = "proCelular1")
    private String proCelular1;

    @Column(name = "proCelular2")
    private String proCelular2;

    @Column(name = "proEndereco")
    private String proEndereco;

    @Column(name = "proComplemento")
    private String proComplemento;

    @Column(name = "proBairro")
    private String proBairro;

    @Column(name = "proCidade")
    private String proCidade;

    @Column(name = "proUF")
    private String proUF;

    @Column(name = "proCPF")
    private String proCPF;

    @Column(name = "proRG")
    private String proRG;

    @Column(name = "proEmail")
    private String proEmail;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @Column(name = "proStatus")
    private String proStatus;
    @Column(name = "proSuperUsuario")
    private Boolean proSuperUsuario;

//    @ManyToOne(optional = true)
//    @JoinColumn(name = "funEmpCodigo", referencedColumnName = "empCodigo")
//    private Empresa funEmpCodigo;

    @Temporal(TemporalType.DATE)
    @Column(name = "proDataNasc")
    private Date proDataNasc;

    @Temporal(TemporalType.DATE)
    @Column(name = "proDataCadastro")
    private Date proDataCadastro;

    public Profissional() {
    }
    public Profissional(Integer codigo) { this.proCodigo = codigo;    }

    public Profissional(String nome) {
        this.proNome = nome;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public String getProCelular1() {
        return proCelular1;
    }

    public void setProCelular1(String proCelular1) {
        this.proCelular1 = proCelular1;
    }

    public String getProCelular2() {
        return proCelular2;
    }

    public void setProCelular2(String proCelular2) {
        this.proCelular2 = proCelular2;
    }

    public String getProEndereco() {
        return proEndereco;
    }

    public void setProEndereco(String proEndereco) {
        this.proEndereco = proEndereco;
    }

    public String getProBairro() {
        return proBairro;
    }

    public void setProBairro(String proBairro) {
        this.proBairro = proBairro;
    }

    public String getProCidade() {
        return proCidade;
    }

    public void setProCidade(String proCidade) {
        this.proCidade = proCidade;
    }

    public String getProUF() {
        return proUF;
    }

    public void setProUF(String proUF) {
        this.proUF = proUF;
    }

    public String getProCPF() {
        return proCPF;
    }

    public void setProCPF(String proCPF) {
        this.proCPF = proCPF;
    }

    public String getProRG() {
        return proRG;
    }

    public void setProRG(String proRG) {
        this.proRG = proRG;
    }

    public Date getProDataNasc() {
        return proDataNasc;
    }

    public void setProDataNasc(Date proDataNasc) {
        this.proDataNasc = proDataNasc;
    }

    public String getProEmail() {
        return proEmail;
    }

    public void setProEmail(String proEmail) {
        this.proEmail = proEmail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(Date proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getProComplemento() {
        return proComplemento;
    }

    public void setProComplemento(String proComplemento) {
        this.proComplemento = proComplemento;
    }

    public Boolean getProSuperUsuario() {
        return proSuperUsuario;
    }

    public void setProSuperUsuario(Boolean proSuperUsuario) {
        this.proSuperUsuario = proSuperUsuario;
    }

    public Escola getProfissionalEscola() {
        return profissionalEscola;
    }

    public void setProfissionalEscola(Escola profissionalEscola) {
        this.profissionalEscola = profissionalEscola;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //usado no autentication - spring security
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() { //usado no autentication - spring security
        return senha;
    }

    @Override
    public String getUsername() { //usado no autentication - spring security
        return login;
    }

    @Override
    public boolean isAccountNonExpired() { //usado no autentication - spring security
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //usado no autentication - spring security
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //usado no autentication - spring security
        return true;
    }

    @Override
    public boolean isEnabled() { //usado no autentication - spring security
        return true;
    }
}
