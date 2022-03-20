package com.example.agro.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="funcionarios")
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String sexo;
//    @JsonFormat(pattern="dd/MM/yyyy")
    private String dataNascimento;
//    @JsonFormat(pattern="dd/MM/yyyy")
    private String admissao;

    @OneToOne
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(String nome, String sobrenome, String cpf, String endereco, String telefone, String sexo, String dataNascimento, String admissao, Empresa empresa) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.admissao = admissao;
        this.empresa = empresa;
    }

}
