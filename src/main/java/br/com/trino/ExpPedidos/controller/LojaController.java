package br.com.trino.ExpPedidos.controller;

import br.com.trino.ExpPedidos.loja.DadosAtualizarLoja;
import br.com.trino.ExpPedidos.loja.DadosCadastroLoja;
import br.com.trino.ExpPedidos.loja.Loja;
import br.com.trino.ExpPedidos.loja.LojaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("loja")
public class LojaController {

    @Autowired
    private LojaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLoja dados) {
        var loja = new Loja(dados);
        repository.save(loja);
        return ResponseEntity.ok("Cadastrado!");
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarLoja dados) {
        var loja = repository.getReferenceById(dados.id());
        loja.validadorAtivo(loja.getAtivo());
        loja.atualizarInformacoes(dados);
        return ResponseEntity.ok("Atualizado!");
    }

    @GetMapping
    public ResponseEntity listar() {
        var loja = repository.findAll();
        return ResponseEntity.ok(loja);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desabilitar(@PathVariable Long id){
        var loja = repository.getReferenceById(id);
        loja.desabilitar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity habilitar(@PathVariable Long id){
        var loja = repository.getReferenceById(id);
        loja.habilitar();
        return ResponseEntity.noContent().build();
    }

}
