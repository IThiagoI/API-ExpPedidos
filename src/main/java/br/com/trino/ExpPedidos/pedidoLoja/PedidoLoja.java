package br.com.trino.ExpPedidos.PedidoLoja;

import br.com.trino.ExpPedidos.loja.Loja;
import br.com.trino.ExpPedidos.usuario.Usuario;
import jakarta.persistence.*;

@Table(name = "pedido_loja")
@Entity(name = "PedidoLoja")
public class PedidoLoja {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private DateTime data;
    @ManyToOne
    private Loja id_loja;
    @ManyToOne
    private Usuario id_usuario;

    public PedidoLoja(long id, DateTime data, Loja id_loja, Usuario id_usuario) {
        this.id = id;
        this.data = data;
        this.id_loja = id_loja;
        this.id_usuario = id_usuario;
    }

    public PedidoLoja() {}

    public long getId() {
        return id;
    }

    public DateTime getData() {
        return data;
    }

    public Loja getId_loja() {
        return id_loja;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }
}
