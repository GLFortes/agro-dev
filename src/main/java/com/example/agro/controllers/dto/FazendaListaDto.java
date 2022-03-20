package com.example.agro.controllers.dto;

import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FazendaListaDto {
    
    Long id;
    String nome;
    Long tempo;
    Calendar dataUltimaColheita;
    Calendar dataProxColheita;
    Grao grao;
    
    public FazendaListaDto(Fazenda fazenda) {
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.tempo = fazenda.getGrao().getTempoColeta();
        this.dataUltimaColheita = fazenda.getDataUltimaColheita();
        fazenda.getDataUltimaColheita().add(Calendar.DATE, Math.toIntExact(fazenda.getGrao().getTempoColeta()));
        this.grao = fazenda.getGrao();

//        this.dataProximaColheita = dataUltimaColheita;
//        dataProximaColheita.add(Calendar.DATE, grao.getTempoColeta());
    }

    public static List<FazendaListaDto> converter(List<Fazenda> fazendas) {
        return fazendas.stream().map(FazendaListaDto::new).collect(java.util.stream.Collectors.toList());
    }

    }

