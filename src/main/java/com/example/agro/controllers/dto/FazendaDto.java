package com.example.agro.controllers.dto;

import com.example.agro.models.Empresa;
import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;
import com.example.agro.services.FazendaService;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class FazendaDto {

    private Long id;
    private String nome;
    private String endereco;
    private Double quilos;
    String dataUltimaColheita;
    private Empresa empresa;
    private Grao grao;

    public FazendaDto(Fazenda fazenda){
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.endereco = fazenda.getEndereco();
        this.quilos = fazenda.getQuilos();
        this.dataUltimaColheita = fazenda.getDate();
        this.empresa = fazenda.getEmpresa();
        this.grao = fazenda.getGrao();
    }

    public static List<FazendaDto> converter(List<Fazenda> fazendas) {
        return fazendas.stream().map(FazendaDto::new).collect(java.util.stream.Collectors.toList());
    }

    public Fazenda aumentaQuantidade(Long id, Double acrescimo, FazendaService service) {
        Fazenda fazenda = service.buscarPorId(id).get();
        Double quantidade = fazenda.getQuilos();
        quantidade += acrescimo;
        fazenda.setQuilos(quantidade);

        return fazenda;
    }
}
