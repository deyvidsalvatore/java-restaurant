package com.wylianedamaso.restaurant.app;

import com.wylianedamaso.restaurant.cardapio.Lanche;
import com.wylianedamaso.restaurant.pedido.Pedido;

public class Main {
    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        RestauranteFacade restaurante = new RestauranteFacade();

        int opcao = -1;

        while (opcao != 0){
            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {
                case 1:
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = restaurante.criarPedido(nomeCliente);

                    boolean adicionarMais = true;

                    while (adicionarMais){
                        int opcaoLanche = menu.lerOpcaoLanche();

                        Lanche lanche = restaurante.criarLanche(opcaoLanche);

                        menu.personalizarLanche(lanche);

                        restaurante.adicionarLanche(pedido, lanche);

                        adicionarMais = menu.desejaAdicionarOutroLanche();
                    }

                    menu.exibirPedido(pedido);

                    break;

                case 2:
                    menu.exibirListaPedidos(restaurante.listarPedidos());

                    break;

                case 3:
                    double total = restaurante.calcularTotalDoDia();

                    menu.exibirFechamentoDoDia(total);

                    break;

                case 0:
                    menu.exibirMensagemSaida();
                    break;

                default:
                    menu.exibirOpcaoInvalida();
                    break;

            }
        }
    }
}
