package com.wylianedamaso.restaurant.cardapio.adicionais;

import com.wylianedamaso.restaurant.cardapio.ItemCardapio;

public class ComBaconExtra implements ItemCardapio {

    private ItemCardapio itemEmbrulhado;

    public ComBaconExtra (ItemCardapio item){
        this.itemEmbrulhado = item;
    }

    @Override
    public String getDescricao() {
        return itemEmbrulhado.getDescricao() + " + bacon extra";
    }

    @Override
    public double getPreco() {
        return itemEmbrulhado.getPreco() + 6.00;
    }
}
