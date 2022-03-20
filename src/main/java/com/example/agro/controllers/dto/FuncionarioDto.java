package com.example.agro.controllers.dto;

import com.example.agro.models.Empresa;
import com.example.agro.models.Funcionario;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class FuncionarioDto {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String sexo;
    private String dataNascimento;
    private Empresa empresa;

    public FuncionarioDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.sobrenome = funcionario.getSobrenome();
        this.cpf = funcionario.getCpf();
        this.endereco = funcionario.getEndereco();
        this.telefone = funcionario.getTelefone();
        this.sexo = funcionario.getSexo();
        this.dataNascimento = funcionario.getDataNascimento();
        this.empresa = funcionario.getEmpresa();
    }

    public static List<FuncionarioDto> converter(List<Funcionario> funcionarios){
        return funcionarios.stream().map(FuncionarioDto::new).collect(java.util.stream.Collectors.toList());
    }


}
