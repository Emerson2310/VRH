package com.vrh.RH.business;

import com.vrh.RH.infrastructure.repository.VagaRepository;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    private final VagaRepository repository;

    public VagaService(VagaRepository repository){
        this.repository = repository;
    }
}
