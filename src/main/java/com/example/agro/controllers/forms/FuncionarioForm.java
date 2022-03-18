package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.models.Funcionario;
import com.example.agro.repositories.EmpresaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class FuncionarioForm {
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String sobrenome;
//    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$", message = "cpf inválido")
    @NotNull @NotEmpty
    private String cpf;
    @NotNull @NotEmpty
    private Empresa empresa;
    @NotNull @NotEmpty
    private String endereco;
    @NotNull @NotEmpty
    private String telefone;
    @NotNull @NotEmpty
    private String sexo;
//    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull @NotEmpty
    private String dataNascimento;
//    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull @NotEmpty
    private String admissao;


//    public Funcionario converter(EmpresaRepository empresaRepository) throws ParseException {
//        Empresa empresa = empresaRepository.findByNome(this.nomeEmpresa);
//        return new Funcionario(nome, sobrenome, cpf, endereco, telefone, sexo, dataNascimento, admissao, empresa);
//    }

    public Funcionario converter(){
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome(this.nome);
        novoFuncionario.setSobrenome(this.sobrenome);
        novoFuncionario.setCpf(this.cpf);
        novoFuncionario.setEmpresa(this.empresa);
        novoFuncionario.setEndereco(this.endereco);
        novoFuncionario.setTelefone(this.telefone);
        novoFuncionario.setSexo(this.sexo);
        novoFuncionario.setDataNascimento(this.dataNascimento);
        novoFuncionario.setAdmissao(this.admissao);
        return novoFuncionario;

    }
}
