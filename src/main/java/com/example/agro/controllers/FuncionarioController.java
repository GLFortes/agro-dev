package com.example.agro.controllers;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.controllers.dto.FazendaDto;
import com.example.agro.controllers.dto.FuncionarioDto;
import com.example.agro.controllers.forms.EmpresaForm;
import com.example.agro.controllers.forms.FazendaForm;
import com.example.agro.controllers.forms.FuncionarioForm;
import com.example.agro.models.Empresa;
import com.example.agro.models.Fazenda;
import com.example.agro.models.Funcionario;
import com.example.agro.repositories.EmpresaRepository;
import com.example.agro.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService service;

    @Autowired
    private EmpresaRepository empresaRepository;

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

    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> cadastrar(@RequestBody @Valid FuncionarioForm form, UriComponentsBuilder uriBuilder){
        Funcionario novoFuncionario = service.cadastrarFuncionario(form.converter());
        URI uri = UriComponentsBuilder.fromPath("/funcionario/{id}").buildAndExpand(novoFuncionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new FuncionarioDto(novoFuncionario));
    }

//    @PutMapping("/{id}")

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> removerFuncionario(@PathVariable Long id){
        Optional<Funcionario> funcionario = service.buscarPorId(id);
        if (funcionario.isPresent()){
            service.deletar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/funcionarioEmpresa/{id}")
    public List<FuncionarioDto> listarPorEmpresa(@PathVariable Long id){
        List<Funcionario> funcionarios = service.acharPorEmpresa(id);
        return FuncionarioDto.converter(funcionarios);
    }

    @GetMapping("/contarPorEmpresa/{id}")
    public int contarPorEmpresa(@PathVariable Long id){
        int quantidade = service.quantidadeDeFuncionarios(id);
        return quantidade;
    }

    }

