package com.example.agro.controllers;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.controllers.dto.FuncionarioDto;
import com.example.agro.controllers.forms.EmpresaForm;
import com.example.agro.controllers.forms.FuncionarioForm;
import com.example.agro.models.Empresa;
import com.example.agro.models.Funcionario;
import com.example.agro.repositories.EmpresaRepository;
import com.example.agro.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

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

    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> adicionarFuncionario(@RequestBody FuncionarioForm form, UriComponentsBuilder uriBuilder) throws ParseException {
        Funcionario funcionario = form.converter(empresaRepository);
        service.cadastrarFuncionario(funcionario);

        URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).body(new FuncionarioDto(service.cadastrarFuncionario(funcionario)));

    }
}
