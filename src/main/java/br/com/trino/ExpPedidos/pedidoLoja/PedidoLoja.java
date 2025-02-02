package br.com.trino.ExpPedidos.pedidoLoja;

import br.com.trino.ExpPedidos.loja.Loja;
import br.com.trino.ExpPedidos.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "pedido_loja")
@Entity(name = "PedidoLoja")
public class PedidoLoja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja id_loja;
    @ManyToOne
    @JoinColumn(name = "id_loja_destino")
    private Loja id_loja_destino;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    public PedidoLoja(LocalDate data, Loja id_loja, Loja id_loja_destino, Usuario id_usuario) {
        this.data = data;
        this.id_loja = id_loja;
        this.id_loja_destino = id_loja_destino;
        this.id_usuario = id_usuario;
    }

    public PedidoLoja() {}

    public long getId() {return id;}

    public LocalDate getData() {return data;}

    public Loja getId_loja() {return id_loja;}

    public Usuario getId_usuario() {return id_usuario;}

    public Loja getId_loja_destino() {return id_loja_destino;}

}
