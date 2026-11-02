package com.wylianedamaso.restaurant.pedido;

import com.wylianedamaso.restaurant.cardapio.Lanche;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorPedidosTest {

    private GerenciadorPedidos gerenciador;

    @BeforeEach
    void setUp() {
        gerenciador = new GerenciadorPedidos();
    }

    @Test
    void deveCriarPedidosComNumerosSequenciais() {
        // GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        Pedido ana = gerenciador.criarPedido("Ana");
        Pedido carlos = gerenciador.criarPedido("Carlos");

        assertEquals(1, ana.getNumero());
        assertEquals(2, carlos.getNumero());
    }

    @Test
    void deveBuscarPedidoExistente() {
        // GerenciadorPedidos gerenciador = new GerenciadorPedidos();
        Pedido pedido = gerenciador.criarPedido("Ana");

        assertSame(pedido, gerenciador.buscarPedido(1));
    }

    @Test
    void deveRetornarNullQuandoPedidoNaoExistir() {
        // GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        assertNull(gerenciador.buscarPedido(99));
    }

    @Test
    void deveCalcularTotalDeTodosOsPedidos() {
        // GerenciadorPedidos gerenciador = new GerenciadorPedidos();

        Pedido ana = gerenciador.criarPedido("Ana");
        ana.adicionarItem(new Lanche("X-Burger", 16.00));

        Pedido carlos = gerenciador.criarPedido("Carlos");
        carlos.adicionarItem(new Lanche("X-Salada", 18.00));

        assertEquals(34.00, gerenciador.calcularTotalDoDia(), 0.001);
    }
}

