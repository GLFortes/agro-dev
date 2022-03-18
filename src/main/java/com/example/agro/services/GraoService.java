package com.example.agro.services;

import com.example.agro.models.Grao;
import com.example.agro.repositories.GraoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GraoService {

    private final GraoRepository graoRepository;

    public GraoService(GraoRepository graoRepository) {
        this.graoRepository = graoRepository;
    }

    public List<Grao> listaGraos(){
        return graoRepository.findAll();
    }

    public Grao adicionaGrao(Grao grao){
        return graoRepository.save(grao);
    }

    public Grao atualizaGrao(Long id, Grao grao){
        Grao graoAtual = graoRepository.findById(id).get();
        graoAtual.setNome(grao.getNome());
        graoAtual.setTempoColeta(grao.getTempoColeta());
        return graoRepository.save(graoAtual);
    }

    public void deletaGrao(Long id){
        graoRepository.deleteById(id);
    }

    public Optional<Grao> buscaGraoPorId(Long id) {
        return graoRepository.findById(id);
    }
}

