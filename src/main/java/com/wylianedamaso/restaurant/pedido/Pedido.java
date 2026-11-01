package com.wylianedamaso.restaurant.pedido;

import com.wylianedamaso.restaurant.cardapio.ItemCardapio;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;

    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    public Pedido(int numero, String nomeCliente){
        this.numero = numero;
        setNomeCliente(nomeCliente);

    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.isBlank()){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nomeCliente = nomeCliente;
    }

    public void adicionarItem(ItemCardapio item){
        itens.add(item);

    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public double calcularTotal(){
        double total = 0;
        for (ItemCardapio item : itens){
            total += item.getPreco();
        }
        return total;
    }

    public boolean removerItem(int numeroEscolhido) {
        int indice = numeroEscolhido - 1;

        if (itens.isEmpty()) {
            return false;
        } else if (indice >= 0 && indice < itens.size()) {
            itens.remove(indice);
            return true;
        }
        return false;
    }
}
