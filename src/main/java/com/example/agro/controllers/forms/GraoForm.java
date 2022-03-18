package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.models.Grao;
import com.example.agro.repositories.EmpresaRepository;
import com.example.agro.services.EmpresaService;
import com.example.agro.services.GraoService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GraoForm {
    @NotBlank
    private String nome;
    @NotNull @NotEmpty
    private Empresa empresa;
    @NotNull
    private Long tempoColeta;

    public Grao converter() {
        Grao novoGrao = new Grao();
        novoGrao.setNome(nome);
        novoGrao.setEmpresa(empresa);
        novoGrao.setTempoColeta(tempoColeta);
        return novoGrao;
    }
}
