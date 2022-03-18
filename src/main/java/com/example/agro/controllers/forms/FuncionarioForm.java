package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.models.Funcionario;
import com.example.agro.repositories.EmpresaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionarioForm {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String nome;
    private String sobrenome;
    private String cpf;
//    private Empresa empresa;
    private String endereco;
    private String telefone;
    private String sexo;
    @JsonFormat(pattern="dd/MM/yyyy")
    private String dataNascimento;
    @JsonFormat(pattern="dd/MM/yyyy")
    private String admissao;
    private String nomeEmpresa;


    public Funcionario converter(EmpresaRepository empresaRepository) throws ParseException {
        Empresa empresa = empresaRepository.findByNome(this.nomeEmpresa);
        return new Funcionario(nome, sobrenome, cpf, endereco, telefone, sexo, dataNascimento, admissao, empresa);
    }
}
