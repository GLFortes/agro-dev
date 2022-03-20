package com.example.agro.services;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.models.Empresa;
import com.example.agro.models.Funcionario;
import com.example.agro.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<Empresa> listarEmpresa() {
        return (List<Empresa>)  repository.findAll();
    }

    public Empresa adicionaEmpresa(Empresa empresa){
        return repository.save(empresa);
    }


    //salva a entidade atualizada no banco
    public Empresa atualizaEmpresa(Long id, Empresa empresa){
        try{
            Empresa entity = repository.getOne(id);
            atualizaDados(entity, empresa);
            return repository.save(entity);
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Não foi possível encontrar a empresa com o id: " + id);
        }
    }

    //Atualiza os dados da entidade no banco
    public void atualizaDados(Empresa entity, Empresa obj){
        entity.setNome(obj.getNome());
        entity.setCnpj(obj.getCnpj());
        entity.setEndereco(obj.getEndereco());
    }

    //deleta empresa
    public void deletaEmpresa(Long id){
        repository.deleteById(id);
    }

    //Busca empresa pelo nome
//    public Optional<Empresa> buscaEmpresa(String nome) {
//        Empresa empresa = repository.findByNome(nome);
//        return Optional.ofNullable(empresa);
//    }

    //Busca empresa pelo nome(deixei os dois métodos pois vou testar melhor após eu receber a nota
    public Empresa findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Empresa findById(Long id) {
    return repository.findById(id).get();
    }
}
