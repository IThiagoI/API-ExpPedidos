package br.com.trino.ExpPedidos.produto;

import br.com.trino.ExpPedidos.diasProducao.DiasSemana;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(

        @NotNull
        Long id,
        String nome,
        int min_producao,
        int qtd_embalado
) {
}
