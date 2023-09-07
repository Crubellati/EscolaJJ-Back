package com.r2csistemas.escolajj.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.r2csistemas.escolajj.orm.Profissional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Profissional profissional) {
        try {
            var algorithm = Algorithm.HMAC256("minhaSenhaSecreta12345");
            return JWT.create()
                    .withIssuer("API EscolaJJ")
                    .withSubject(profissional.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
           throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm = Algorithm.HMAC256("minhaSenhaSecreta12345");
            return JWT.require(algorithm)
                    .withIssuer("API EscolaJJ")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
           throw new RuntimeException("Token JWT inválido ou expirado.");
        }
    }
}
