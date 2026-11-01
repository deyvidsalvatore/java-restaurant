package com.wylianedamaso.restaurant.pedido;

import com.wylianedamaso.restaurant.cardapio.Lanche;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PedidoTest {

    @Test
    void deveCriarPedidoComDadosValidos(){
        Pedido pedido = new Pedido(1,"Ana");
        assertEquals(1, pedido.getNumero());
        assertEquals("Ana", pedido.getNomeCliente());
    }
    @Test
    void deveLancarErroQuandoNomeClienteForNulo(){
        assertThrows(IllegalArgumentException.class, () -> new Pedido(1, null));
    }

    @Test
    void deveAdicionarLancheAoPedido(){
        Pedido pedido = new Pedido(1, "Ana");
        Lanche lanche = new Lanche("X-Burger", 16.00);

        pedido.adicionarItem(lanche);

        assertEquals(1, pedido.getItens().size());
        assertEquals("X-Burger", pedido.getItens().get(0).getDescricao());
    }

    @Test
    void deveCalcularTotalDosLanches(){
        Pedido pedido = new Pedido(1, "Ana");
        pedido.adicionarItem(new Lanche("X-Burger", 16.00));pedido.adicionarItem(new Lanche("X-Salada", 18.00));

        assertEquals(34, pedido.calcularTotal(), 0.001);
    }
}
