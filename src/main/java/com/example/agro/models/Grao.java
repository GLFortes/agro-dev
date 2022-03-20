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
    private Long tempoColeta;

    @ManyToOne
//    @JoinColumn(name = "id_tipo_grao")
    private Empresa empresa;

    public Grao(){}

    public Grao(String nome, Empresa empresa, Long tempoColeta){
        this.nome = nome;
        this.empresa = empresa;
        this.tempoColeta = tempoColeta;
    }

}
