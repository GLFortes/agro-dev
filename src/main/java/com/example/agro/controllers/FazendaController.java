package com.example.agro.controllers;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.controllers.dto.FazendaDto;
import com.example.agro.controllers.forms.FazendaForm;
import com.example.agro.models.Empresa;
import com.example.agro.models.Fazenda;
import com.example.agro.repositories.FazendaRepository;
import com.example.agro.repositories.GraoRepository;
import com.example.agro.services.FazendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {
    private FazendaService fazendaService;

    private GraoRepository graoRepository;
    public FazendaController(FazendaService fazendaService){
        this.fazendaService = fazendaService;
    }

    @GetMapping
    public List<FazendaDto> listar(){
        List<Fazenda> fazendas = fazendaService.listar();
        return FazendaDto.converter(fazendas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FazendaDto> cadastrar(@RequestBody @Valid FazendaForm form, UriComponentsBuilder uriBuilder){
        Fazenda fazenda = fazendaService.adicionarFazenda(form.converter(graoRepository));
        URI uri = uriBuilder.path("/fazenda/{id}").buildAndExpand(fazenda.getId()).toUri();
        return ResponseEntity.created(uri).body(new FazendaDto(fazenda));
    }
}
