package com.vrh.RH.controller;

import com.vrh.RH.business.CandidatoService;
import com.vrh.RH.infrastructure.entitys.Candidato;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController (CandidatoService candidatoService){
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarCandidato(@RequestBody Candidato candidato){
        candidatoService.salvarCandidato(candidato);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Candidato> buscarCandidatoPorEmail(@RequestParam String email){
        return ResponseEntity.ok(candidatoService.buscarPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarCandidatoPorEmail(@RequestParam String email){
        candidatoService.deletarCandidatoPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCandidatoPorId(@RequestParam Integer id,
                                                        @RequestBody Candidato candidato){
        candidatoService.atualizarCandidatoPorId(id, candidato);
        return ResponseEntity.ok().build();
    }


}
