package com.example.agro.services;

import com.example.agro.models.Fazenda;
import com.example.agro.repositories.FazendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaService {
    private final FazendaRepository fazendaRepository;

    public FazendaService(FazendaRepository fazendaRepository) {
        this.fazendaRepository = fazendaRepository;
    }

    public List<Fazenda> listar(){
        return fazendaRepository.findAll();
    }
    public Fazenda adicionarFazenda(Fazenda fazenda){
        return fazendaRepository.save(fazenda);
    }

    public void deletaFazenda(Long id){
        fazendaRepository.deleteById(id);
    }


}
