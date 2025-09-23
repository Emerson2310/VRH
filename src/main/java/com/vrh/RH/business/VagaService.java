package com.vrh.RH.business;

import com.vrh.RH.infrastructure.entitys.Vaga;
import com.vrh.RH.infrastructure.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VagaService {

    private final VagaRepository VagaRepository;

    public VagaService(VagaRepository repository){
        this.VagaRepository = repository;
    }


    public void salvarVaga(Vaga vaga){
        VagaRepository.saveAndFlush(vaga);
    }


    public void atualizarVagaPorId(Integer id, Vaga vaga){
        Vaga vagaEntity = VagaRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Vaga não encontrada"));
        Vaga vagaAtualizada = Vaga.builder()
                .titulo(vaga.getTitulo() != null ?
                        vaga.getTitulo() : vagaEntity.getTitulo())
                .dec(vaga.getDec() != null ?
                        vaga.getDec() : vagaEntity.getDec())
                .id(vagaEntity.getId())
                .build();
        VagaRepository.saveAndFlush(vagaAtualizada);
    }
}
