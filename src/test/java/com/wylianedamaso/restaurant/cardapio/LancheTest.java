package com.wylianedamaso.restaurant.cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LancheTest {

    @Test
    void deveCriarLancheComDadosValidos(){
        Lanche lanche = new Lanche("X-Burger", 16.00);
        assertEquals("X-Burger", lanche.getNome());
        assertEquals(16.00, lanche.getPreco(), 0.001);
    }

    @Test
    void deveLancarErroQuandoPrecoForNegativo(){
        assertThrows(IllegalArgumentException.class, () -> new Lanche("X-Burger", -1.0));

    }

    @Test
    void deveLancarErroQuandoNomeForVazio(){
        assertThrows(IllegalArgumentException.class, () -> new Lanche("", 16.00));
    }

    @Test
    void deveLancarErroQuandoNomeForNull() {
        assertThrows(IllegalArgumentException.class, () -> new Lanche(null, 16.00));
    }

    @Test
    void deveCriarLancheComTodosIngredientesDisponiveis() {
        Lanche lanche = new Lanche("X-Bacon", 22.00);

        assertTrue(lanche.isQueijo());
        assertTrue(lanche.isAlface());
        assertTrue(lanche.isTomate());
        assertTrue(lanche.isCebola());
    }

    @Test
    void deveRetirarCebolaDaDescricaoDoLanche() {
        Lanche lanche = new Lanche("X-Bacon", 22.00);

        lanche.setCebola(false);

        assertEquals("X-Bacon sem cebola", lanche.getDescricao());
    }

    @Test
    void deveRetirarMultiplosIngredientesDaDescricaoDoLanche() {
        Lanche lanche = new Lanche("X-Bacon", 22.00);

        lanche.setCebola(false);
        lanche.setTomate(false);

        assertEquals("X-Bacon sem tomate sem cebola", lanche.getDescricao());
    }
}
