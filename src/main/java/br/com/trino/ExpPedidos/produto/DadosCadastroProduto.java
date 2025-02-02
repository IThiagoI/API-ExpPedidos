package br.com.trino.ExpPedidos.produto;

import br.com.trino.ExpPedidos.diasProducao.DiasSemana;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(

        @NotBlank
        String nome,

        @NotNull
        int min_producao,

        @NotNull
        int qtd_embalado
) {
}
