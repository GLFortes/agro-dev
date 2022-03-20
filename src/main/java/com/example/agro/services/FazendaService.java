package com.example.agro.services;

import com.example.agro.models.Fazenda;
import com.example.agro.repositories.FazendaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public Fazenda atualiza(Long id, Fazenda fazenda){
        try{
            Fazenda entity = fazendaRepository.getOne(id);
            atualizaDados(entity, fazenda);
            return fazendaRepository.save(entity);
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Não foi possível encontrar a fazenda com o id: " + id);
        }
    }

    public void atualizaDados(Fazenda entity, Fazenda obj){
        entity.setNome(obj.getNome());
        entity.setEndereco(obj.getEndereco());
        entity.setEmpresa(obj.getEmpresa());
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


    public int quantidadeDeFazendas(Long id){
        return fazendaRepository.countByEmpresaId(id);
    }



}



