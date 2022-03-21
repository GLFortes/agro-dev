package com.example.agro.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "CNPJ inválido")
    private String cnpj;
    private String endereco;


    public Empresa(){

    }

    public Empresa(String nome, String cnpj, String endereco){
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

}
