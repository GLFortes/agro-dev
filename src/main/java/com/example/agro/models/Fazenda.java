package com.example.agro.models;

import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
    }


}
