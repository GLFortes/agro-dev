package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.models.Grao;
import com.example.agro.repositories.EmpresaRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class GraoForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String empresaNome;

    public Grao converter(EmpresaRepository empresaRepository) {
        Empresa empresa = empresaRepository.findByNome(empresaNome);
        return new Grao(nome, empresa);
    }
}
