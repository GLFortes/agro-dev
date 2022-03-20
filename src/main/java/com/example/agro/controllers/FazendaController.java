package com.example.agro.controllers;

import com.example.agro.controllers.dto.EmpresaDto;
import com.example.agro.controllers.dto.FazendaDto;
import com.example.agro.controllers.dto.FazendaListaDto;
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
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {
    private FazendaService fazendaService;

    private GraoRepository graoRepository;
    public FazendaController(FazendaService fazendaService){
        this.fazendaService = fazendaService;
    }

    //Lista todas as fazendas cadastradas no BD
    @GetMapping
    public List<FazendaDto> listar(){
        List<Fazenda> fazendas = fazendaService.listar();
        return FazendaDto.converter(fazendas);
    }

    //Cadastra uma nova fazenda
    @PostMapping
    @Transactional
    public ResponseEntity<FazendaDto> cadastrar(@RequestBody @Valid FazendaForm form, UriComponentsBuilder uriBuilder) throws ParseException {
        Fazenda fazenda = fazendaService.adicionarFazenda(form.converter());
        URI uri = UriComponentsBuilder.fromPath("/fazenda/{id}").buildAndExpand(fazenda.getId()).toUri();
        return ResponseEntity.created(uri).body(new FazendaDto(fazenda));
    }

    //Deleta uma fazenda por ID
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Fazenda> fazenda = fazendaService.buscarPorId(id);
        if(fazenda.isPresent()){
            fazendaService.deletaFazenda(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Retorna uma lista de fazenda de acordo com o ID da empresa
    @GetMapping("/{id}")
    public List<FazendaDto> fazendasPorEmpresa(@PathVariable Long id){
        List<Fazenda> fazendas = fazendaService.acharPorEmpresa(id);
        return FazendaDto.converter(fazendas);
    }

    //Retorna uma lista de fazendas de acordo com o ID da empresa, mostrando apenas o nome da fazenda, seu ID e data da proxima colheita (ainda não funcional)
    @GetMapping("/fazendasDetalhes/{id}")
    public List<FazendaListaDto> listarFazendaDetalhada(@PathVariable Long id){
        List<Fazenda> fazendas = fazendaService.acharPorEmpresa(id);
        return FazendaListaDto.converter(fazendas);
    }


    //Registrar uma colheita
    @PutMapping("/aumentar/{id}")
    public ResponseEntity<FazendaDto> aumentarGraos(@PathVariable Long id, @RequestParam double quantidade) throws ParseException {
        Optional<Fazenda> optional = fazendaService.buscarPorId(id);
        if(optional.isPresent()){
            FazendaDto fazendaDto = optional.map(FazendaDto::new).get();
            Fazenda fazenda = fazendaDto.aumentaQuantidade(id, quantidade, fazendaService);
            fazendaService.adicionarFazenda(fazenda);
            return ResponseEntity.ok(new FazendaDto(fazenda));
        }
        return ResponseEntity.notFound().build();

    }

    //Subtrai uma quantidade enviada por parâmetro do estoque de grãos da fazenda (a busca é feita pelo ID
    @PutMapping("/diminuir/{id}")
    public ResponseEntity<FazendaDto> diminuirGraos(@PathVariable Long id, @RequestParam double quantidade){
        Optional<Fazenda> optional = fazendaService.buscarPorId(id);
        if(optional.isPresent()){
            FazendaDto fazendaDto = optional.map(FazendaDto::new).get();
            Fazenda fazenda = fazendaDto.diminuiQuantidade(id, quantidade, fazendaService);
            fazendaService.adicionarFazenda(fazenda);
            return ResponseEntity.ok(new FazendaDto(fazenda));
        }
        return ResponseEntity.notFound().build();
    }

//
    @GetMapping("/contarPorEmpresa/{id}")
    public int contarPorEmpresa(@PathVariable Long id){
        int quantidade = fazendaService.quantidadeDeFazendas(id);
        return quantidade;
    }

//    @GetMapping("/ordenarQuantidade/{id}")
//        public List<FazendaDto> ordenarPorQuantidade(@PathVariable Long id){
//            List<Fazenda> fazendas = fazendaService.ordenarPorQuantidade(id);
//            return FazendaDto.converter(fazendas);
//        }

}
