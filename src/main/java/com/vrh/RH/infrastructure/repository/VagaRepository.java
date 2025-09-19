package com.vrh.RH.infrastructure.repository;

import com.vrh.RH.infrastructure.entitys.Candidato;
import com.vrh.RH.infrastructure.entitys.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {
}
