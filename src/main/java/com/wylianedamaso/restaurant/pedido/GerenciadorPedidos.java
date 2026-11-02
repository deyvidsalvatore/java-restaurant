package com.wylianedamaso.restaurant.pedido;

import com.wylianedamaso.restaurant.cardapio.ItemCardapio;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GerenciadorPedidos {

    // Final também pois o objeto pedidos não vai mudar, apenas vai ser inserido novos valores referenciando esse objeto
    private final HashMap<Integer, Pedido> pedidos = new HashMap<>();

    private int contadorPedidos = 1;

    public Set<String> listarLanchesDiferentes() {
        Set<String> lanchesDiferentes = new HashSet<>();
        for (Pedido pedido : pedidos.values()){
            for (ItemCardapio item : pedido.getItens()){
                lanchesDiferentes.add(item.getDescricao());
            }
        }

        return lanchesDiferentes;
    }

    public Pedido criarPedido(String nomeCliente) {
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novo.getNumero(), novo);
        contadorPedidos++;
        return novo;
    }


    public Pedido buscarPedido(int numero) {
        return pedidos.get(numero);

    }

    public Collection<Pedido> getPedidos() {
        return pedidos.values();
    }

    public double calcularTotalDoDia() {
        double total = 0;
        for (Pedido pedido : pedidos.values()){
            total += pedido.calcularTotal();
        }
        return total;
    }

    public boolean cancelarPedido(int numero){
        return pedidos.remove(numero) != null;
    }
}
