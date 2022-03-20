package com.example.agro.controllers;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.controllers.forms.EmpresaForm;
import com.example.agro.models.Empresa;
import com.example.agro.services.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService service;

    public EmpresaController (EmpresaService service){
        this.service = service;
    }

    //Retorna uma lista de empresas cadastrada no BD
    @GetMapping
    public List<EmpresaDto> listar(){
        List<Empresa> empresas = service.listarEmpresa();
        return EmpresaDto.converter(empresas);
    }

    //Cadastra uma nova empresa no BD
    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaDto> cadastrarEmpresa(@RequestBody EmpresaForm form, UriComponentsBuilder uriBuilder){
        Empresa empresa = form.converter();

        URI uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmpresaDto(service.adicionaEmpresa(empresa)));

    }

    //Atualiza uma empresa no BD
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa obj){
        obj = service.atualizaEmpresa(id, obj);
        return ResponseEntity.ok(obj);
    }

    //Deleta uma empresa no BD
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id){
        service.deletaEmpresa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDto> buscarEmpresa(@PathVariable Long id){
        Empresa empresa = service.findById(id);
        return ResponseEntity.ok(new EmpresaDto(empresa));
    }
}
