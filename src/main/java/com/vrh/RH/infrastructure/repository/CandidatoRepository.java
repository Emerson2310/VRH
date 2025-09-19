package com.vrh.RH.infrastructure.repository;

import com.vrh.RH.infrastructure.entitys.Candidato;
import com.vrh.RH.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

    Optional<Candidato> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
