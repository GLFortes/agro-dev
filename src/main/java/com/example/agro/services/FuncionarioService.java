package com.example.agro.services;

import com.example.agro.models.Funcionario;
import com.example.agro.models.Grao;
import com.example.agro.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listar(){
        return funcionarioRepository.findAll();
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(Long id){
        funcionarioRepository.deleteById(id);
    }

    public Optional<Funcionario> buscarPorId(Long id){
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> acharPorEmpresa(Long id){
        return (List<Funcionario>) funcionarioRepository.findByEmpresa(id);
    }

    public int quantidadeDeFuncionarios(Long id) {
        return funcionarioRepository.countByEmpresa(id);
    }
}
