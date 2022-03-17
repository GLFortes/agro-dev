package com.example.agro.controllers.dto;

import com.example.agro.models.Empresa;
import lombok.Getter;

import java.util.List;

@Getter
public class EmpresaDto {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;


    public EmpresaDto(Empresa empresa){
        this.id = empresa.getId();
        this.nome = empresa.getNome();
        this.cnpj = empresa.getCnpj();
        this.endereco = empresa.getEndereco();
    }

    public static List<EmpresaDto> converter(List<Empresa> empresas){
        return empresas.stream().map(EmpresaDto::new).collect(java.util.stream.Collectors.toList());
    }

}
