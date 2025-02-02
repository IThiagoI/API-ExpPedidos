package br.com.trino.ExpPedidos.controller;

import br.com.trino.ExpPedidos.diasProducao.DadosAtualizarDiasProducao;
import br.com.trino.ExpPedidos.diasProducao.DadosCadastroDiasProducao;
import br.com.trino.ExpPedidos.diasProducao.DiasProducao;
import br.com.trino.ExpPedidos.diasProducao.DiasProducaoRepository;
import br.com.trino.ExpPedidos.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diasProducao")
public class DiasProducaoController {

    @Autowired
    private DiasProducaoRepository diasProducaoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDiasProducao dados) {
        var produto = produtoRepository.getReferenceById(dados.id_produto());
        produto.validadorAtivo(produto.getAtivo());
        var diasProducao = new DiasProducao(produto,dados.dia_producao());
        diasProducaoRepository.save(diasProducao);
        return ResponseEntity.ok("Cadastrado!");
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDiasProducao dados){
        var diasProducao = diasProducaoRepository.getReferenceById(dados.id());
        diasProducao.atualizar(dados);
        return ResponseEntity.ok("Atualizado!");
    }
    @GetMapping
    public ResponseEntity listar(){
        var diasProducao = diasProducaoRepository.findAll();
        return ResponseEntity.ok(diasProducao);
    }
}
