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
    public Empresa adicionarEmpresa(@RequestBody EmpresaForm form){
        return service.adicionaEmpresa(form.converter());

    }

    @PutMapping("/{id}")
    @Transactional
    public Empresa atualizaEmpresa(@PathVariable Long id, @RequestBody EmpresaForm form){
        return service.atualizaEmpresa(id, form.converter());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletaEmpresa(@PathVariable Long id){
        Optional<Empresa> empresa = service.buscaEmpresa(id);
        if(empresa.isPresent()){
            service.deletaEmpresa(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
