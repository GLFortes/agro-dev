package com.example.agro.controllers.dto;

import com.example.agro.models.Grao;
import lombok.Getter;

@Getter
public class GraoDto {

    private Long id;
    private String nome;
    private String nomeEmpresa;

    public GraoDto(Grao grao){
        this.id = grao.getId();
        this.nome = grao.getNome();
        this.nomeEmpresa = grao.getEmpresa().getNome();
    }
}
