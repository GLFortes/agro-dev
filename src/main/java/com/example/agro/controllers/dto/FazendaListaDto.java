package com.example.agro.controllers.dto;

import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

/*
* DTO utilizado para implementar a lógica de de incrementar a data das colheitas. Tentativa sem sucesso, apenas deixarei a classe aqui para eu poder modificar após a avaliação do projeto
* */
@Getter
public class FazendaListaDto {
    
    private Long id;
    private String nome;
    private Integer tempo;
//    Calendar dataUltimaColheita;
//    Calendar dataProxColheita;
    private LocalDate dataUltimaColheita;
    private LocalDate dataProxColheita;
    private Grao grao;
    
    public FazendaListaDto(Fazenda fazenda) {
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.dataProxColheita = fazenda.getDataProximaColheita().plusDays(fazenda.getGrao().getTempoColeta());
    }

    public static List<FazendaListaDto> converter(List<Fazenda> fazendas) {
        return fazendas.stream().map(FazendaListaDto::new).collect(java.util.stream.Collectors.toList());
    }

    }

