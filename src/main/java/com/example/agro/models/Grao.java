package com.example.agro.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "graos")
public class Grao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne
    private Empresa empresa;

    public Grao(){}

    public Grao(String nome, Empresa empresa){
        this.nome = nome;
        this.empresa = empresa;
    }

}
