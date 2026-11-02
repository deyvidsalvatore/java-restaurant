package com.wylianedamaso.restaurant.restaurante;

import com.wylianedamaso.restaurant.cardapio.ItemCardapio;
import com.wylianedamaso.restaurant.cardapio.Lanche;
import com.wylianedamaso.restaurant.cardapio.LancheFactory;
import com.wylianedamaso.restaurant.pedido.GerenciadorPedidos;
import com.wylianedamaso.restaurant.pedido.Pedido;

import java.util.Collection;
import java.util.Set;

public class RestauranteFacade {

    // Final também, o objeto em si é imutável
    private final GerenciadorPedidos gerenciador;

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

    // Usei uma feature da versão 14 do Java que é o Switch Expressions
    // https://openjdk.org/jeps/361 <- Link
    public Lanche criarLanche(int opcao){
        return switch (opcao) {
            case 1 -> LancheFactory.xBurger();
            case 2 -> LancheFactory.xSalada();
            case 3 -> LancheFactory.xBacon();
            default -> throw new IllegalArgumentException("Opção de lanche inválida");
        };
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
