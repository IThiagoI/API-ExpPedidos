package br.com.trino.ExpPedidos.diasProducao;

import br.com.trino.ExpPedidos.produto.Produto;
import jakarta.persistence.*;

@Table(name = "dias_producao")
@Entity(name = "DiasProducao")
public class DiasProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto id_produto;
    @Enumerated(EnumType.STRING)
    private DiasSemana dia_producao;

    public DiasProducao(Produto id_produto, DiasSemana dia_producao) {
        this.id_produto = id_produto;
        this.dia_producao = dia_producao;
    }

    public DiasProducao() {};

    public void atualizar(DadosAtualizarDiasProducao dados){
        this.dia_producao = dados.dia_producao();
    }

    public DiasSemana getDia_producao() {
        return dia_producao;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public Long getId() {
        return id;
    }
}
