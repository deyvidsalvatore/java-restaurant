package com.wylianedamaso.restaurant.menu;

import com.wylianedamaso.restaurant.restaurante.RestauranteFacade;
import com.wylianedamaso.restaurant.cardapio.Lanche;
import com.wylianedamaso.restaurant.pedido.Pedido;

/*
* O Controlador agora faz parte do MVC da tua aplicação para simplificar o menu e deixar a Main mais limpa
* View - Menu Console (Que é onde interago e exibe para mim as informações do Lanche, Cliente, etc)
* Controller - Controlador Menu que coordena as ações
* Model - Domínio e as regras (Modelo da base de dados Lanche, Pedido e etc)
 */
public class ControladorMenu {

    // Padrão de Injeção de Dependência - DI
    private final MenuConsole menu;
    private final RestauranteFacade restaurante;

    public ControladorMenu(MenuConsole menu,
                           RestauranteFacade restaurante) {
        this.menu = menu;
        this.restaurante = restaurante;
    }

    public void executar() {
        int opcao;

        do {
            menu.exibirMenu();
            opcao = menu.lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 0);
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> criarPedido();
            case 2 -> listarPedidos();
            case 3 -> fecharDia();
            case 4 -> removerItem();
            case 5 -> adicionarLanche();
            case 6 -> cancelarPedido();
            case 0 -> menu.exibirMensagemSaida();
            default -> menu.exibirOpcaoInvalida();
        }
    }

    private void criarPedido() {
        String nomeCliente = menu.lerNomeCliente();
        Pedido pedido = restaurante.criarPedido(nomeCliente);

        boolean adicionarMais;

        do {
            adicionarLancheAoPedido(pedido);
            adicionarMais = menu.desejaAdicionarOutroLanche();
        } while (adicionarMais);

        menu.exibirPedido(pedido);
    }

    private void listarPedidos() {
        menu.exibirListaPedidos(restaurante.listarPedidos());
    }

    private void fecharDia() {
        double total = restaurante.calcularTotalDoDia();

        menu.exibirFechamentoDoDia(total);
        menu.exibirLanchesDiferentes(
                restaurante.listarLanchesDoDia()
        );
    }

    private void removerItem() {
        Pedido pedido = buscarPedido();

        if (pedido == null) {
            return;
        }

        menu.exibirItensPedido(pedido);

        int numeroItem = menu.lerNumeroItem();

        boolean removido =
                restaurante.removerItem(pedido, numeroItem);

        if (removido) {
            menu.exibirItemRemovido();
        } else {
            menu.exibirErroRemoverItem();
        }
    }

    private void adicionarLanche() {
        Pedido pedido = buscarPedido();

        if (pedido == null) {
            return;
        }

        adicionarLancheAoPedido(pedido);
    }

    private void cancelarPedido() {
        int numero = menu.lerNumeroPedido();

        boolean cancelado = restaurante.cancelarPedido(numero);

        if (cancelado) {
            menu.exibirPedidoCancelado();
        } else {
            menu.exibirErroCancelarPedido();
        }
    }

    private Pedido buscarPedido() {
        int numero = menu.lerNumeroPedido();
        Pedido pedido = restaurante.buscarPedido(numero);

        if (pedido == null) {
            menu.exibirPedidoNaoEncontrado();
        }

        return pedido;
    }

    private void adicionarLancheAoPedido(Pedido pedido) {
        int opcaoLanche = menu.lerOpcaoLanche();

        Lanche lanche = restaurante.criarLanche(opcaoLanche);

        menu.personalizarLanche(lanche);

        restaurante.adicionarLanche(pedido, lanche);
    }
}
