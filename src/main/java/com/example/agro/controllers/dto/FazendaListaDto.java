package com.example.agro.controllers.dto;

import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;

import java.time.LocalDate;
import java.util.List;

public class FazendaListaDto {
    
    Long id;
    String nome;
    Integer tempo;
//    Calendar dataUltimaColheita;
//    Calendar dataProxColheita;
    LocalDate dataUltimaColheita;
    LocalDate dataProxColheita;
    Grao grao;
    
    public FazendaListaDto(Fazenda fazenda) {
        this.grao = fazenda.getGrao();
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.tempo = fazenda.getGrao().getTempoColeta();
        this.dataUltimaColheita = fazenda.getDataUltimaColheita();
//      fazenda.getDataUltimaColheita().add(Calendar.DATE, Math.toIntExact(fazenda.getGrao().getTempoColeta()));
        this.dataProxColheita = fazenda.getDataUltimaColheita().plusDays(fazenda.getGrao().getTempoColeta());


//        this.dataProximaColheita = dataUltimaColheita;
//        dataProximaColheita.add(Calendar.DATE, grao.getTempoColeta());
    }

    public static List<FazendaListaDto> converter(List<Fazenda> fazendas) {
        return fazendas.stream().map(FazendaListaDto::new).collect(java.util.stream.Collectors.toList());
    }

    }

