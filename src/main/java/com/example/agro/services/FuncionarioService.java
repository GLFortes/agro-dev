package com.example.agro.services;

import com.example.agro.models.Funcionario;
import com.example.agro.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
