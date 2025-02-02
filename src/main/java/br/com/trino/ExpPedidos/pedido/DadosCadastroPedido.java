package br.com.trino.ExpPedidos.pedido;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record DadosCadastroPedido(

        @NotNull
        LocalDate data,

        @NotNull
        Long id_loja,

        @NotNull
        Long id_loja_destino,

        @NotNull
        Long id_usuario,

        @NotNull
        Long id_produto,

        @NotNull
        int quantidade
) {}
