
package com.wylianedamaso.restaurant.pedido;

import com.wylianedamaso.restaurant.cardapio.Lanche;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    // Reaproveitando as variáveis
    private Pedido pedido;
    private Lanche lanche;

    // Setando o que já tem lá nos testes que é base do X-Burguer e a Cliente 'Ana'
    @BeforeEach
    void configuration() {
        pedido = new Pedido(1, "Ana");
        lanche = new Lanche("X-Burger", 16.00);
    }

    @Test
    void deveCriarPedidoComDadosValidos() {
        assertEquals(1, pedido.getNumero());
        assertEquals("Ana", pedido.getNomeCliente());
    }

    @Test
    void deveLancarErroQuandoNomeClienteForNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pedido(1, null));
    }

    @Test
    void deveAdicionarLancheAoPedido() {
        pedido.adicionarItem(lanche);

        assertEquals(1, pedido.getItens().size());
        assertEquals("X-Burger",
                pedido.getItens().get(0).getDescricao());
    }

    @Test
    void deveCalcularTotalDosLanches() {
        pedido.adicionarItem(lanche);
        pedido.adicionarItem(new Lanche("X-Salada", 18.00));

        assertEquals(34.00, pedido.calcularTotal(), 0.001);
    }
}
