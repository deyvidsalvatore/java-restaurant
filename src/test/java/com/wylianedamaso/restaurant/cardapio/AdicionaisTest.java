package com.wylianedamaso.restaurant.cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdicionaisTest {

    @Test
    void xBaconComCheddarCusta26(){
        ItemCardapio lanche = new ComCheddar(LancheFactory.xBacon());

        assertEquals(26.00, lanche.getPreco(), 0.001);
    }

    @Test
    void deveAdicionarBaconExtraAoLanche(){
        ItemCardapio lanche = new ComBaconExtra(LancheFactory.xBacon());

        assertEquals(28.00, lanche.getPreco(), 0.001);
    }

    @Test
    void deveSomarOsDoisAdicionaisAoLanche(){
        ItemCardapio lanche = new ComBaconExtra(new ComCheddar(LancheFactory.xBacon()));

        assertEquals(32.00, lanche.getPreco(), 0.001);
        assertEquals("X-Bacon + cheddar + bacon extra", lanche.getDescricao());
    }

    @Test
    void deveManterOrdemDosAdicionaisNaDescricao() {
        ItemCardapio lanche = new ComCheddar(new ComBaconExtra(LancheFactory.xBacon()));

        assertEquals("X-Bacon + bacon extra + cheddar", lanche.getDescricao());
    }
}
