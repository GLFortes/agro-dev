package com.example.agro.controllers;

import com.example.agro.controllers.dto.FuncionarioDto;
import com.example.agro.controllers.forms.FuncionarioForm;
import com.example.agro.models.Funcionario;
import com.example.agro.services.EmpresaService;
import com.example.agro.services.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<FuncionarioDto> listar(){
        List<Funcionario> funcionarios = service.listar();
        return FuncionarioDto.converter(funcionarios);
    }

//    @PostMapping
//    @Transactional
//    public Funcionario adicionarFuncionario(@RequestBody FuncionarioForm form){
//        return service.cadastrarFuncionario(form.converter());
//    }

    //Cadatastra um novo funcionário
    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> cadastrar(@RequestBody @Valid FuncionarioForm form, UriComponentsBuilder uriBuilder){
        Funcionario novoFuncionario = service.cadastrarFuncionario(form.converter());
        URI uri = UriComponentsBuilder.fromPath("/funcionario/{id}").buildAndExpand(novoFuncionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new FuncionarioDto(novoFuncionario));
    }

    //Atualiza Funcionário
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario obj){
        obj = service.atualizaFuncionario(id, obj);
        return ResponseEntity.ok(obj);
    }
//    public Funcionario atualizaFuncionario(@PathVariable Long id, @RequestBody FuncionarioForm form) throws ParseException {
//        return service.atualizaFuncionario(id, form.convert(empresaService));
//    }

    //Deleta um funcionário pelo seu ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaFuncionario(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    //Retorna uma lista de funcionários de uma determinada empresa(a busca é feita pelo ID da empresa)
    @GetMapping("/funcionarioEmpresa/{id}")
    public List<FuncionarioDto> listarPorEmpresa(@PathVariable Long id){
        List<Funcionario> funcionarios = service.acharPorEmpresa(id);
        return FuncionarioDto.converter(funcionarios);
    }

    //Retorna a quantidade de funcionários alocados em uma empresa(a busca é feita pelo ID da empresa)
    @GetMapping("/contarPorEmpresa/{id}")
    public int contarPorEmpresa(@PathVariable Long id){
        int quantidade = service.quantidadeDeFuncionarios(id);
        return quantidade;
    }

    }

