package com.example.agro.controllers;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.controllers.forms.EmpresaForm;
import com.example.agro.models.Empresa;
import com.example.agro.services.EmpresaService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService service;

    public EmpresaController (EmpresaService service){
        this.service = service;
    }

    @GetMapping
    public List<EmpresaDto> listar(){
        List<Empresa> empresas = service.listarEmpresa();
        return EmpresaDto.converter(empresas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaDto> adicionarEmpresa(@RequestBody EmpresaForm form, UriComponentsBuilder uriBuilder){
        Empresa empresa = form.converter();

        URI uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmpresaDto(service.adicionaEmpresa(empresa)));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EmpresaDto> atualizaEmpresa(@PathVariable Long id, @RequestBody EmpresaForm form){
        Optional<Empresa> empresa = service.buscaEmpresa(String.valueOf(id));
        if(empresa.isPresent()){
            Empresa empresaAtualizada = service.atualizaEmpresa(id, form.converter());
            return ResponseEntity.ok(new EmpresaDto(empresaAtualizada));
        }
        return ResponseEntity.notFound().build();
//        return service.atualizaEmpresa(id, form.converter());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaEmpresa(@PathVariable Long id){
        Optional<Empresa> empresa = service.buscaEmpresa(String.valueOf(id));
        if(empresa.isPresent()){
            service.deletaEmpresa(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
