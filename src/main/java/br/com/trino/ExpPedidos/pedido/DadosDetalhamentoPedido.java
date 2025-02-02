package br.com.trino.ExpPedidos.pedido;

import br.com.trino.ExpPedidos.pedidoLoja.PedidoLoja;

import java.time.LocalDate;

public record DadosDetalhamentoPedido(LocalDate data, Long id_loja, Long id_loja_destino, Long id_usuario, Long id_pedido_loja, Long id_produto, int quantidade) {

    public DadosDetalhamentoPedido(PedidoLoja pedidoLoja, Pedido pedido) {
        this(pedidoLoja.getData(), pedidoLoja.getId_loja().getId(), pedidoLoja.getId_loja_destino().getId(), pedidoLoja.getId_usuario().getId(), pedido.getId_pedido_loja().getId(), pedido.getId_produto().getId(), pedido.getQuantidade());
    }
}
