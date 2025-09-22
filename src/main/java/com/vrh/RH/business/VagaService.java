package com.vrh.RH.business;

import com.vrh.RH.infrastructure.entitys.Candidato;
import com.vrh.RH.infrastructure.entitys.Vaga;
import com.vrh.RH.infrastructure.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VagaService {

    private final VagaRepository repository;

    public VagaService(VagaRepository repository){
        this.repository = repository;
    }


    public void salvarVaga(Vaga vaga){
        repository.saveAndFlush(vaga);
    }

    public Optional<Vaga> buscarPorId(Vaga vaga){
        return repository.findById(vaga.getId());
    }

    public void atualizarCandidatoPorId(Integer id, Vaga vaga){
        Vaga vagaEntity = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Vaga não encontrada"));
        Vaga vagaAtualizada = Vaga.builder()
                .titulo(vaga.getTitulo() != null ?
                        vaga.getTitulo() : vagaEntity.getTitulo())
                .dec(vaga.getDec() != null ?
                        vaga.getDec() : vagaEntity.getDec())
                .id(vagaEntity.getId())
                .build();
        repository.saveAndFlush(vagaAtualizada);
    }
}
