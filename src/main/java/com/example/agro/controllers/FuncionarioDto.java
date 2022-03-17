package com.example.agro.controllers;

import com.example.agro.models.Funcionario;
import lombok.Getter;

import java.util.Date;

@Getter
public class FuncionarioDto {
    private Long id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String telefone;
    private String sexo;
    private Date dataNascimento;
    private String nomeEmpresa;

    public FuncionarioDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.sobrenome = funcionario.getSobrenome();
        this.endereco = funcionario.getEndereco();
        this.telefone = funcionario.getTelefone();
        this.sexo = funcionario.getSexo();
        this.dataNascimento = funcionario.getDataNascimento();
        this.nomeEmpresa = funcionario.getEmpresa().getNome();
    }


}
