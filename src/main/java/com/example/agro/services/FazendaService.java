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
        return (List<Fazenda>) fazendaRepository.findByEmpresaId(id);
    }

    public Fazenda adicionaGrao(Long id, Double quilosAcrescimo){
        Fazenda fazendaAtualizada = fazendaRepository.findById(id).get();
        Double quantidade = fazendaAtualizada.getQuilos();
        quantidade += quilosAcrescimo;
        fazendaAtualizada.setQuilos(quantidade);
        return fazendaRepository.save(fazendaAtualizada);
    }

    public int quantidadeDeFazendas(Long id){
        return fazendaRepository.countByEmpresaId(id);
    }
}



