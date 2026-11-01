package com.wylianedamaso.restaurant.app;

import com.wylianedamaso.restaurant.cardapio.Lanche;
import com.wylianedamaso.restaurant.pedido.Pedido;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

public class MenuConsole {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu(){
        System.out.println("=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Editar pedido");
        System.out.println("5 - Adicionar lanche a um pedido");
        System.out.println("6 - Cancelar pedido");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

    }

    public int lerOpcao(){
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public String lerNomeCliente(){
        System.out.print("Digite o nome do cliente: ");
        return scanner.nextLine();
    }

    public int  lerOpcaoLanche(){
        System.out.println("=== CARDÁPIO ===");
        System.out.println("1 - X-Burger - R$ 16,00");
        System.out.println("2 - X-Salada - R$ 18,00");
        System.out.println("3 - X-Bacon - R$ 22,00");
        System.out.print("Escolha um lanche: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("Cliente: " + pedido.getNomeCliente());
        System.out.println("Total: R$ " + pedido.calcularTotal());
    }

    public void  exibirFechamentoDoDia(double total){
        System.out.println("=== FECHAMENTO DO DIA ===");
        System.out.printf("Total do dia: R$ %.2f%n", total);

    }

    public boolean desejaAdicionarOutroLanche() {
        System.out.print("Deseja adicionar outro lanche? (s/n): ");
        String resposta = scanner.nextLine();

        return resposta.equalsIgnoreCase("s")
                || resposta.equalsIgnoreCase("sim");
    }

    public void exibirListaPedidos(Collection<Pedido> pedidos) {
        System.out.println("=== PEDIDOS DO DIA ===");

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.printf(
                    "Pedido %d | Cliente: %s | Total: R$ %.2f%n",
                    pedido.getNumero(),
                    pedido.getNomeCliente(),
                    pedido.calcularTotal()
            );
        }

    }

    public void exibirMensagemSaida() {
        System.out.println("Sistema encerrado. Até logo!");
    }

    public void exibirOpcaoInvalida() {
        System.out.println("Opção inválida. Tente novamente.");
    }

    public void personalizarLanche(Lanche lanche) {
        System.out.println("Deseja remover algum ingrediente do lanche? (s/n)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")){
            System.out.println("Deseja retirar queijo? (s/n)");
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                lanche.setQueijo(false);
            }
            System.out.println("Deseja retirar alface? (s/n)");
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                lanche.setAlface(false);
            }
            System.out.println("Deseja retirar tomate? (s/n)");
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                lanche.setTomate(false);
            }
            System.out.println("Deseja retirar cebola? (s/n)");
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                lanche.setCebola(false);
            }
        }
    }

    public int lerNumeroPedido() {
        System.out.print("Digite o número do pedido: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    public void exibirItensPedido(Pedido pedido){
        for (int i = 0; i < pedido.getItens().size(); i++){
            System.out.println((i + 1) + " - " + pedido.getItens().get(i).getDescricao());
        }
    }

    public int lerNumeroItem() {
        System.out.print("Digite o número do lanche que deseja remover: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    public void exibirPedidoNaoEncontrado() {
        System.out.println("Pedido não encontrado.");
    }

    public void exibirItemRemovido() {
        System.out.println("Lanche removido com sucesso!");
    }

    public void exibirErroRemoverItem() {
        System.out.println("Não foi possível remover o lanche.");
    }

    public void exibirPedidoCancelado() {
        System.out.println("Pedido cancelado com sucesso!");
    }

    public void exibirErroCancelarPedido() {
        System.out.println("Pedido não encontrado. Não foi possível cancelar.");
    }

    public void exibirLanchesDiferentes(Set<String> lanchesDiferentes) {
        System.out.println("Quantidade de lanches diferentes: " + lanchesDiferentes.size());

        for (String lanche : lanchesDiferentes) {
            System.out.println("- " + lanche);
        }
    }
}
