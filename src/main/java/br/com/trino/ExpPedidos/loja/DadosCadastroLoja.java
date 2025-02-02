package br.com.trino.ExpPedidos.loja;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroLoja(

        @NotBlank
        String nome,

        @NotNull
        long cnpj
) {
}
