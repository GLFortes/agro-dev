package com.example.agro.controllers;

import com.example.agro.controllers.dto.GraoDto;
import com.example.agro.controllers.forms.GraoForm;
import com.example.agro.models.Grao;
import com.example.agro.repositories.EmpresaRepository;
import com.example.agro.services.EmpresaService;
import com.example.agro.services.GraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/graos")
public class GraoController {

    private GraoService service;

   private EmpresaRepository empresaRepository;


    public GraoController(GraoService service) {
        this.service = service;
    }

    @GetMapping
    public List<GraoDto> listar(){
        List<Grao> graos = service.listaGraos();
        return GraoDto.converter(graos);
    }

//    @PostMapping
//    @Transactional
//    public ResponseEntity<GraoDto> cadastrar(@RequestBody GraoForm form, UriComponentsBuilder uriBuilder){
//        service.adicionaGrao(form.converter());
//
//        URI uri = uriBuilder.path("/graos/{id}").buildAndExpand(form.getId()).toUri();
//        return ResponseEntity.created(uri).body(new GraoDto(grao));
//    }

    @PostMapping
    @Transactional
    public Grao adicionaGrao(@RequestBody GraoForm form){
        return service.adicionaGrao(form.converter());
    }

//    @PutMapping("/{id}")
//    @Transactional
//    public ResponseEntity<GraoDto> atualizar(@PathVariable Long id, @RequestBody GraoForm form){
//        Optional<Grao> optional = service.buscaGraoPorId(id);
//        if(optional.isPresent()){
//            Grao grao = service.atualizaGrao(id, form.converter((EmpresaRepository) empresaRepository));
//            return ResponseEntity.ok(new GraoDto(grao));
//        }
//        return ResponseEntity.notFound().build();
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Grao> optional = service.buscaGraoPorId(id);
        if(optional.isPresent()){
            service.deletaGrao(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
