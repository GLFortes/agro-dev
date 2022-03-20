package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FazendaForm {
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    private Double quilos;
    private String date;

    private Empresa empresa;
    private Grao grao;


    public Fazenda converter(){
        Fazenda novaFazenda = new Fazenda();
        novaFazenda.setNome(nome);
        novaFazenda.setEndereco(endereco);
        novaFazenda.setEmpresa(empresa);
        novaFazenda.setGrao(grao);
        novaFazenda.setQuilos(quilos);
        novaFazenda.setDate(date);
        return novaFazenda;
    }
}
