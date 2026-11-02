package com.wylianedamaso.restaurant.cardapio.adicionais;

import com.wylianedamaso.restaurant.cardapio.ItemCardapio;

public class ComCheddar implements ItemCardapio {
    // Final pois o objeto em si não vai mudar, apenas o atributo dentro dele
    private final ItemCardapio itemEmbrulhado;

    public ComCheddar(ItemCardapio item){
        this.itemEmbrulhado = item;
    }

    @Override
    public String getDescricao() {
        return itemEmbrulhado.getDescricao() + " + cheddar";
    }

    @Override
    public double getPreco() {
        return itemEmbrulhado.getPreco() + 4.00;
    }
}
