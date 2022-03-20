package com.example.agro.services;

import com.example.agro.models.Funcionario;
import com.example.agro.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public Funcionario atualizaFuncionario(Long id, Funcionario funcionario){
        try{
            Funcionario entity = funcionarioRepository.getOne(id);
            atualizaDados(entity, funcionario);
            return funcionarioRepository.save(entity);
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Não foi possível encontrar o funcionário com o id: " + id);

        }
    }
    public void atualizaDados(Funcionario entity, Funcionario obj){
        entity.setNome(obj.getNome());
        entity.setSobrenome(obj.getSobrenome());
        entity.setCpf(obj.getCpf());
        entity.setDataNascimento(obj.getDataNascimento());
        entity.setEndereco(obj.getEndereco());
        entity.setTelefone(obj.getTelefone());
        entity.setSexo(obj.getSexo());
        entity.setAdmissao(obj.getAdmissao());
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
