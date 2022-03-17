package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.repositories.EmpresaRepository;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EmpresaForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$")
    private String cnpj;
    @NotNull @NotEmpty
    private String endereco;

    public Empresa converter() {
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        empresa.setCnpj(cnpj);
        empresa.setEndereco(endereco);
        return empresa;
    }

}
