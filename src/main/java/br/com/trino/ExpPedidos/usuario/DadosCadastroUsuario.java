package br.com.trino.ExpPedidos.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(

        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @NotNull
        NvlAcesso nivel_acesso
) {
}
