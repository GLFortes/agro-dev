package com.example.agro.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
@Entity
@Table(name="funcionarios")
public class Funcionario {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    //validar cpf
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}$", message = "CPF inválido")
    private String cpf;
    private String endereco;

    //validar telefone (xx)xxxx-xxxx (não consegui implementar, sempre retornava um erro 500. Devo ter tido problemas de sintaxe)

    private String telefone;
    private String sexo;
    private String dataNascimento;
    private Calendar nascimentoCalendar = Calendar.getInstance();
    private String admissao;
    private Calendar admissaoCalendar = Calendar.getInstance();

    @OneToOne
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(String nome, String sobrenome, String cpf, String endereco, String telefone, String sexo, String dataNascimento, String admissao, Empresa empresa) throws ParseException {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.admissao = admissao;
        nascimentoCalendar.setTime(sdf.parse(dataNascimento));
        admissaoCalendar.setTime(sdf.parse(admissao));
        this.empresa = empresa;

    }

}
