package com.example.agro.models;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table(name="fazendas")
public class Fazenda {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private Double quilos;
    //regex date
//    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", message = "Data inválida")
    private String date;
    private LocalDate dataUltimaColheita = LocalDate.now();
    private LocalDate dataProximaColheita = LocalDate.now();

    @OneToOne
    private Grao grao;
    @OneToOne
    private Empresa empresa;

    public Fazenda(){}

    public Fazenda(String nome, String endereco, Double quilos, Grao grao, String date) throws ParseException {
        this.nome = nome;
        this.endereco = endereco;
        this.quilos = quilos;
        this.grao = grao;
        this.empresa = grao.getEmpresa();
        dataUltimaColheita = LocalDate.now();
        dataProximaColheita = dataUltimaColheita.plusDays(grao.getTempoColeta());
//        dataUltimaColheita.setTime(sdf.parse(date));
    }

//    public void setDateParse(String date) throws ParseException {
//        this.date = date;
//        this.dataUltimaColheita = sdf.parse(date);
//    }
}
