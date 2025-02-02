package br.com.trino.ExpPedidos.pedidoLoja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoLojaRepository extends JpaRepository<PedidoLoja,Long> { }
