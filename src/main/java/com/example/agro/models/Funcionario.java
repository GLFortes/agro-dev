package com.example.agro.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table(name="funcionarios")
public class Funcionario {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/", message = "CPF inválido")
    private String cpf;
    private String endereco;
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Telefone inválido")
    private String telefone;
    private String sexo;
//    @JsonFormat(pattern="dd/MM/yyyy")
    private String dataNascimento;
    private Calendar nascimentoCalendar = Calendar.getInstance();
//    @JsonFormat(pattern="dd/MM/yyyy")
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
//        this.dataNascimento = dataNascimento;
//        this.admissao = admissao;
        nascimentoCalendar.setTime(sdf.parse(dataNascimento));
        admissaoCalendar.setTime(sdf.parse(admissao));
        this.empresa = empresa;

    }

}
