package com.example.agro.services;

import com.example.agro.models.Fazenda;
import com.example.agro.repositories.FazendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Fazenda> buscarPorId(Long id){
        return fazendaRepository.findById(id);
    }

    public List<Fazenda> acharPorEmpresa(Long id){
        return (List<Fazenda>) fazendaRepository.findByEmpresa(id);
    }
}



