package com.example.agro.controllers.forms;

import com.example.agro.models.Empresa;
import com.example.agro.models.Funcionario;
import com.example.agro.services.EmpresaService;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;

@Data
public class FuncionarioForm {
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String sobrenome;
    //valida cpf
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$", message = "CPF inválido")
    @NotNull @NotEmpty
    private String cpf;
    @NotNull
    private Empresa empresa;
    @NotNull @NotEmpty
    private String endereco;
    //valida telefone
    @Pattern(regexp = "^\\([0-9]{2}\\)[0-9]{9}$", message = "Telefone inválido")
    @NotNull @NotEmpty
    private String telefone;
    @NotNull @NotEmpty
    private String sexo;
    @NotNull @NotEmpty
    private String dataNascimento;
    @NotNull @NotEmpty
    private String admissao;


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

    public Funcionario convert(EmpresaService empresaService) throws ParseException {
        Empresa empresa = empresaService.findByNome(String.valueOf(this.empresa));
        return new Funcionario(nome, sobrenome, cpf, endereco, telefone, sexo, dataNascimento, admissao, empresa);
    }
}
