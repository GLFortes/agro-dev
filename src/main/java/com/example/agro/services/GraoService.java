package com.example.agro.services;

import com.example.agro.models.Grao;
import com.example.agro.repositories.GraoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public Grao atualizaGrao(Long id, Grao grao ){
        try{
            Grao entity = graoRepository.getOne(id);
            atualizaDados(entity, grao);
            return graoRepository.save(entity);
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Não foi possível encontrar o grão com o id: " + id);
        }
    }

    public void atualizaDados(Grao entity, Grao obj){
        entity.setNome(obj.getNome());
        entity.setEmpresa(obj.getEmpresa());
        entity.setTempoColeta(obj.getTempoColeta());
    }

    public void deletaGrao(Long id){
        graoRepository.deleteById(id);
    }

    public Optional<Grao> buscaGraoPorId(Long id) {
        return graoRepository.findById(id);
    }

    public List<Grao> buscarPorEmpresa(Long id){
        return (List<Grao>) graoRepository.findByEmpresaId(id);
    }

    public List<Grao> buscarPorGraoOrdenado(Long id) {
        return graoRepository.findByEmpresaIdOrderByNomeAsc(id);
    }

}

