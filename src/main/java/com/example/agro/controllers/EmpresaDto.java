package com.example.agro.controllers;

import com.example.agro.models.Empresa;
import lombok.Getter;

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
}
