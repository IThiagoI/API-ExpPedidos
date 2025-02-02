package br.com.trino.ExpPedidos.pedido;

import br.com.trino.ExpPedidos.loja.LojaRepository;
import br.com.trino.ExpPedidos.pedidoLoja.PedidoLoja;
import br.com.trino.ExpPedidos.pedidoLoja.PedidoLojaRepository;
import br.com.trino.ExpPedidos.produto.ProdutoRepository;
import br.com.trino.ExpPedidos.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidadorPedidos {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoLojaRepository pedidoLojaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DadosDetalhamentoPedido pedido(DadosCadastroPedido dados){

        if(!lojaRepository.existsById(dados.id_loja())){
            throw new ValidationException("Id da loja informada não existe!");
        }
        if(!lojaRepository.existsById(dados.id_loja_destino())){
            throw new ValidationException("Id da loja informada não existe!");
        }
        if(!usuarioRepository.existsById(dados.id_usuario())){
            throw new ValidationException("Id do usuário informado não existe!");
        }
        if(!produtoRepository.existsById(dados.id_produto())){
            throw new ValidationException("Id do produto informado não existe!");
        }

        var lojaValidador = lojaRepository.getReferenceById(dados.id_loja());
        lojaValidador.validadorAtivo(lojaValidador.getAtivo());
        var lojaDestValidador = lojaRepository.getReferenceById(dados.id_loja_destino());
        lojaDestValidador.validadorAtivo(lojaDestValidador.getAtivo());
        var usuarioValidador = usuarioRepository.getReferenceById(dados.id_usuario());
        usuarioValidador.validadorAtivo(usuarioValidador.getAtivo());
        var produtoValidador = produtoRepository.getReferenceById(dados.id_produto());
        produtoValidador.validadorAtivo(produtoValidador.getAtivo());

        var loja = lojaRepository.getReferenceById(dados.id_loja());
        var lojaDestino = lojaRepository.getReferenceById(dados.id_loja_destino());
        var usuario = usuarioRepository.getReferenceById(dados.id_usuario());
        var pedidoLoja = new PedidoLoja(dados.data(), loja, lojaDestino, usuario);
        var idPedidoLoja = pedidoLojaRepository.save(pedidoLoja).getId();

        var pedidoLoja1 = pedidoLojaRepository.getReferenceById(idPedidoLoja);
        var produto = produtoRepository.getReferenceById(dados.id_produto());
        var pedido = new Pedido(pedidoLoja1, produto, dados.quantidade());
        pedidoRepository.save(pedido);

        return new DadosDetalhamentoPedido(pedidoLoja, pedido);
    }
}
