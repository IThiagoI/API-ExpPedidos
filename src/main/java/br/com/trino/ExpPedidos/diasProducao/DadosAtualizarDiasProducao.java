package br.com.trino.ExpPedidos.diasProducao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDiasProducao(

        @NotNull
        Long id,
        @NotNull
        DiasSemana dia_producao
) {
}
