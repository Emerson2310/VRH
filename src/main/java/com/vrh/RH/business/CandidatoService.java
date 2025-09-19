package com.vrh.RH.business;

import com.vrh.RH.infrastructure.entitys.Candidato;
import com.vrh.RH.infrastructure.entitys.Usuario;
import com.vrh.RH.infrastructure.repository.CandidatoRepository;
import com.vrh.RH.infrastructure.repository.VagaRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {

    private final CandidatoRepository repository;

    public CandidatoService (CandidatoRepository repository){
        this.repository = repository;
    }

    public void salvarCandidato(Candidato candidato){
        repository.saveAndFlush(candidato);
    }

    public Candidato buscarPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("Email não encontradao")
        );
    }

    public void deletarCandidatoPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarCandidatoPorId(Integer id, Candidato candidato){
        Candidato candidatoEntity = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Candidato não encontrado"));
        Candidato candidatoAtualizado = Candidato.builder()
                .email(candidato.getEmail() != null ?
                        candidato.getEmail() : candidatoEntity.getEmail())
                .nome(candidato.getNome() != null ? candidato.getNome() :
                        candidatoEntity.getNome())
                .id(candidatoEntity.getId())
                .build();
        repository.saveAndFlush(candidatoAtualizado);
    }
}
