package com.example.agro.models;

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
    private Date dataNascimento;
    private Date admissao;

    @OneToOne
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(String nome, String sobrenome, String cpf, String endereco, String telefone, String sexo, Date dataNascimento, Date admissao, Empresa empresa) {
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
