package com.example.agro.controllers.dto;

import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;
import lombok.Getter;

import java.util.List;

@Getter
public class FazendaOrderDto {
    private String nomeGrao;
    private Double estoque;

    public FazendaOrderDto(Fazenda fazenda) {
        this.nomeGrao = fazenda.getGrao().getNome();
        this.estoque = fazenda.getQuilos();
    }

    public static List<FazendaOrderDto> converter(List<Fazenda> fazendas) {
        return fazendas.stream().map(FazendaOrderDto::new).collect(java.util.stream.Collectors.toList());
    }
}
