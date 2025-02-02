package br.com.trino.ExpPedidos.controller;
import br.com.trino.ExpPedidos.produto.DadosAtualizarProduto;
import br.com.trino.ExpPedidos.produto.DadosCadastroProduto;
import br.com.trino.ExpPedidos.produto.Produto;
import br.com.trino.ExpPedidos.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados){
        var produto = new Produto(dados);
        produtoRepository.save(produto);
        return ResponseEntity.ok("Cadastrado!");
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarProduto dados){
        var produto = produtoRepository.getReferenceById(dados.id());
        produto.validadorAtivo(produto.getAtivo());
        produto.atualizarInformacoes(dados);
        return ResponseEntity.ok("Atualizado!");
    }
    @GetMapping
    public ResponseEntity listar(){
        var produto = produtoRepository.findAll();
        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desabilitar(@PathVariable Long id){
        var produto = produtoRepository.getReferenceById(id);
        produto.desabilitar();
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity habilitar(@PathVariable Long id){
        var produto = produtoRepository.getReferenceById(id);
        produto.habilitar();
        return ResponseEntity.noContent().build();
    }
}
