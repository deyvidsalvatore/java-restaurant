package com.wylianedamaso.restaurant.app;

import com.wylianedamaso.restaurant.cardapio.Lanche;
import com.wylianedamaso.restaurant.menu.ControladorMenu;
import com.wylianedamaso.restaurant.menu.MenuConsole;
import com.wylianedamaso.restaurant.pedido.Pedido;
import com.wylianedamaso.restaurant.restaurante.RestauranteFacade;

public class Main {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        RestauranteFacade restaurante = new RestauranteFacade();

        ControladorMenu controlador =
                new ControladorMenu(menu, restaurante);

        controlador.executar();
    }
}
