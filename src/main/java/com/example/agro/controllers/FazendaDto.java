package com.example.agro.controllers;

import com.example.agro.models.Fazenda;
import lombok.Getter;

@Getter
public class FazendaDto {

    private Long id;
    private String nome;
    private String endereco;
    private Double quilos;

    public FazendaDto(Fazenda fazenda){
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.endereco = fazenda.getEndereco();
        this.quilos = fazenda.getQuilos();
    }
}
