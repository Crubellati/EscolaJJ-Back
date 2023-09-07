package com.r2csistemas.escolajj.controller;

import com.r2csistemas.escolajj.dto.DadosAutenticacao;
import com.r2csistemas.escolajj.dto.DadosTokenJWT;
import com.r2csistemas.escolajj.orm.Profissional;
import com.r2csistemas.escolajj.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authenticate = authenticationManager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Profissional) authenticate.getPrincipal());
        var nomeProfissional = ((Profissional) authenticate.getPrincipal()).getProNome();
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT, nomeProfissional));
    }
}
