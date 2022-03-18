package com.example.agro.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="fazendas")
public class Fazenda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private Double quilos;
    private Date dataUltimaColheita;

    @OneToOne
    private Grao grao;
    @OneToOne
    private Empresa empresa;

    public Fazenda(){}

    public Fazenda(String nome, String endereco, Double quilos, Grao grao, Date dataUltimaColheita) {
        this.nome = nome;
        this.endereco = endereco;
        this.quilos = quilos;
        this.grao = grao;
        this.empresa = grao.getEmpresa();
        this.dataUltimaColheita = dataUltimaColheita;
    }
}
