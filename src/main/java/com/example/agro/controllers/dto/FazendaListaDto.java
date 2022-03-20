package com.example.agro.controllers.dto;

import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;

import java.util.Date;

public class FazendaListaDto {
    
    Long id;
    String nome;
    Long tempo;
    Date dataProxColheita;
    Grao grao;
    
    public FazendaListaDto(Fazenda fazenda) {
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.tempo = fazenda.getGrao().getTempoColeta();
//        this.dataProxColheita = fazenda.getDataUltimaColheita().plusDays(fazenda.getGrao().getTempoColeta());
        this.grao = fazenda.getGrao();
    }

    }

