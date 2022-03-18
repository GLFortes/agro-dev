package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.models.Fazenda;
import com.example.agro.models.Grao;
import com.example.agro.repositories.GraoRepository;
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

    private Empresa empresa;
    private Grao grao;

//    public Fazenda converter(GraoRepository graoRepository) {
//        Grao graozinho = graoRepository.findById(grao.getId()).get();
//        return new Fazenda(nome, endereco, quilos, graozinho);
//
//    }

    public Fazenda converter(){
        Fazenda novaFazenda = new Fazenda();
        novaFazenda.setNome(nome);
        novaFazenda.setEndereco(endereco);
        novaFazenda.setEmpresa(empresa);
        novaFazenda.setGrao(grao);
        novaFazenda.setQuilos(quilos);
        return novaFazenda;
    }
}
