package br.com.trino.ExpPedidos.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(

        @NotNull
        Long id,
        String nome,
        String senha,
        NvlAcesso nivel_acesso
) {
}
