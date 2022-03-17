package com.example.agro.services;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.models.Empresa;
import com.example.agro.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

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

    public Empresa atualizaEmpresa(Long id, Empresa empresa){
        Empresa empresaAtualizada = repository.findById(id).get();
        empresaAtualizada.setNome(empresa.getNome());
        empresaAtualizada.setCnpj(empresa.getCnpj());
        empresaAtualizada.setEndereco(empresa.getEndereco());
        return repository.save(empresaAtualizada);
    }

    public void deletaEmpresa(Long id){
        repository.deleteById(id);
    }

    public Optional<Empresa> buscaEmpresa(Long id) {
        return repository.findById(id);
    }
}
