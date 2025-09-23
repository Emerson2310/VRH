package com.vrh.RH.controller;

import com.vrh.RH.business.VagaService;
import com.vrh.RH.infrastructure.entitys.Vaga;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vaga")
@RequiredArgsConstructor
public class VagaController {

    private final VagaService vagaService;

    @PostMapping
    public ResponseEntity<Void> salvarVaga(@RequestBody Vaga vaga){
        vagaService.salvarVaga(vaga);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Optional<Vaga>> buscarVagaPorId(@RequestParam Integer id){
        return ResponseEntity.ok(vagaService.buscarPorId(id));
    }


}
