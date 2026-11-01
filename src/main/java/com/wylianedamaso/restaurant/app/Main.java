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

                    while (adicionarMais) {
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
                    menu.exibirLanchesDiferentes(restaurante.listarLanchesDoDia());

                    break;

                case 4:
                    int numeroPedido = menu.lerNumeroPedido();
                    Pedido pedidoEditar = restaurante.buscarPedido(numeroPedido);

                    if (pedidoEditar == null) {
                        menu.exibirPedidoNaoEncontrado();
                    } else {
                    menu.exibirItensPedido(pedidoEditar);

                    int numeroItem = menu.lerNumeroItem();

                    boolean removido = restaurante.removerItem(pedidoEditar, numeroItem);

                    if (removido){
                        menu.exibirItemRemovido();
                    } else {
                        menu.exibirErroRemoverItem();
                    }
                    }
                    break;

                case 5:
                    int numPedido = menu.lerNumeroPedido();
                    Pedido pedidoAdicionar = restaurante.buscarPedido(numPedido);

                    if (pedidoAdicionar == null) {
                        menu.exibirPedidoNaoEncontrado();
                    } else {
                        int opcaoLanche = menu.lerOpcaoLanche();

                        Lanche lanche = restaurante.criarLanche(opcaoLanche);

                        menu.personalizarLanche(lanche);

                        restaurante.adicionarLanche(pedidoAdicionar, lanche);

                    }

                    break;

                case 6:
                    int  numero = menu.lerNumeroPedido();
                    boolean pedidoCancelar = restaurante.cancelarPedido(numero);

                        if (pedidoCancelar){
                            menu.exibirPedidoCancelado();
                        } else {
                            menu.exibirErroCancelarPedido();
                        }
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
