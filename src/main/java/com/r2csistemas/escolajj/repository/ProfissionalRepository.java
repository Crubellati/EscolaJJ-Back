package com.r2csistemas.escolajj.repository;

import com.r2csistemas.escolajj.orm.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
    UserDetails findByLogin(String login);
    Optional<Profissional> findByProCodigo(Integer codigo);

    List<Profissional> findByProNomeContainsOrderByProCodigoDesc(String nullToEmpty);
}
