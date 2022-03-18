package com.example.agro.controllers.dto;

import com.example.agro.models.Empresa;
import com.example.agro.models.Fazenda;
import lombok.Getter;

import java.util.List;

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

    public static List<FazendaDto> converter(List<Fazenda> fazendas) {
        return fazendas.stream().map(FazendaDto::new).collect(java.util.stream.Collectors.toList());
    }
}
