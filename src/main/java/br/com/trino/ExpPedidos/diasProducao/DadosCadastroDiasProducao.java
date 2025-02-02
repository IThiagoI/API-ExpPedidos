package br.com.trino.ExpPedidos.diasProducao;

import br.com.trino.ExpPedidos.produto.Produto;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroDiasProducao(

        @NotNull
        Long id_produto,
        @NotNull
        DiasSemana dia_producao
) {
}
