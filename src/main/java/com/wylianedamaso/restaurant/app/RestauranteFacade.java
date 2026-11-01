package com.wylianedamaso.restaurant.app;

import com.wylianedamaso.restaurant.cardapio.ItemCardapio;
import com.wylianedamaso.restaurant.cardapio.Lanche;
import com.wylianedamaso.restaurant.cardapio.LancheFactory;
import com.wylianedamaso.restaurant.pedido.GerenciadorPedidos;
import com.wylianedamaso.restaurant.pedido.Pedido;

import java.util.Collection;
import java.util.Set;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador;

    public RestauranteFacade(){
        gerenciador = new GerenciadorPedidos();
    }

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public void adicionarLanche(Pedido pedido, ItemCardapio item){
        pedido.adicionarItem(item);
    }

    public double calcularTotalDoDia(){
        return gerenciador.calcularTotalDoDia();

    }

    public Collection<Pedido> listarPedidos(){
        return gerenciador.getPedidos();
    }

    public Pedido buscarPedido(int numero){
        return gerenciador.buscarPedido(numero);
    }

    public Lanche criarLanche(int opcao){
        switch (opcao){
            case 1:
                return LancheFactory.xBurger();
            case 2:
                return LancheFactory.xSalada();
            case 3:
                return LancheFactory.xBacon();
            default:
                throw new IllegalArgumentException("Opção de lanche inválida");
        }
    }

    public boolean removerItem(Pedido pedido, int numeroEscolhido){
        return pedido.removerItem(numeroEscolhido);
    }

    public boolean cancelarPedido(int numero){
        return gerenciador.cancelarPedido(numero);
    }

    public Set<String> listarLanchesDoDia(){
        return gerenciador.listarLanchesDiferentes();
    }
}
