package com.example.agro.controllers;

import com.example.agro.controllers.dto.GraoDto;
import com.example.agro.controllers.forms.GraoForm;
import com.example.agro.models.Grao;
import com.example.agro.services.GraoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/graos")
public class GraoController {

    private GraoService service;



    public GraoController(GraoService service) {
        this.service = service;
    }

    //Retorna todos os graos cadastrados no BD
    @GetMapping
    public List<GraoDto> listar(){
        List<Grao> graos = service.listaGraos();
        return GraoDto.converter(graos);
    }


    //Cadastra um grão novo ao BD
    @PostMapping
    @Transactional
    public Grao adicionarGrao(@RequestBody GraoForm form){
        return service.adicionaGrao(form.converter());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Grao> atualizarGrao(@PathVariable Long id, @RequestBody Grao obj){
    obj = service.atualizaGrao(id, obj);
    return ResponseEntity.ok(obj);
}

    //Deleta um grão pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGrao(@PathVariable Long id){
        service.deletaGrao(id);
        return ResponseEntity.noContent().build();
    }

    //Retorna os grãos de uma determinada empresa(a busca é feita pelo ID da empresa)
    @GetMapping("/empresa/{id}")
    public List<GraoDto> listarPorEmpresa(@PathVariable Long id){
        List<Grao> graos = service.buscarPorEmpresa(id);
        return GraoDto.converter(graos);
    }

}



