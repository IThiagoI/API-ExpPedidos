package br.com.trino.ExpPedidos.controller;
import br.com.trino.ExpPedidos.pedido.DadosCadastroPedido;
import br.com.trino.ExpPedidos.pedido.ValidadorPedidos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private ValidadorPedidos validadorPedidos;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPedido dados){
        var pedido = validadorPedidos.pedido(dados);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    @Transactional
    public Page<>
}
