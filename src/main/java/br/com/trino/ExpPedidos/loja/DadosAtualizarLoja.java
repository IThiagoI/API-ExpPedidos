package br.com.trino.ExpPedidos.loja;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLoja(

        @NotNull
        Long id,
        String nome,
        long cnpj
) {
}
