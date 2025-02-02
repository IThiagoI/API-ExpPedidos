package br.com.trino.ExpPedidos.pedido;

import br.com.trino.ExpPedidos.pedidoLoja.PedidoLoja;
import br.com.trino.ExpPedidos.produto.Produto;
import jakarta.persistence.*;

@Table(name = "pedido")
@Entity(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_pedido_loja")
    private PedidoLoja id_pedido_loja;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;
    private int quantidade;

    public Pedido(PedidoLoja id_pedido_loja, Produto id_produto, int quantidade) {
        this.id_pedido_loja = id_pedido_loja;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
    }

    public Pedido() {}

    public long getId() {return id;}

    public PedidoLoja getId_pedido_loja() {return id_pedido_loja;}

    public Produto getId_produto() {return id_produto;}

    public int getQuantidade() {return quantidade;}
}
