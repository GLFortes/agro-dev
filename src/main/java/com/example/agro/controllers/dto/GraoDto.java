package com.example.agro.controllers.dto;

import com.example.agro.models.Empresa;
import com.example.agro.models.Grao;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
public class GraoDto {

    private Long id;
    private String nome;
    private Empresa nomeEmpresa;
    private Integer tempoColeta;

    public GraoDto(Grao grao){
        this.id = grao.getId();
        this.nome = grao.getNome();
        this.nomeEmpresa = grao.getEmpresa();
        this.tempoColeta = grao.getTempoColeta();
    }

    public static List<GraoDto> converter(List<Grao> graos){
        return graos.stream().map(GraoDto::new).collect(java.util.stream.Collectors.toList());
    }

}

