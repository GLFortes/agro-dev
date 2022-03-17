package com.example.agro.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
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
