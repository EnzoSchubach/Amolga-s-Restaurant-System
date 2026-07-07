/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;
import java.util.ArrayList;

/**
 *
 * @author sofia macedo
 */
public class Database {
    private static final ArrayList<String> clients = new ArrayList<>();
    private static final ArrayList<String> items = new ArrayList<>();
    private static final ArrayList<String> orders = new ArrayList<>();
    
    static {
        // Clientes de teste
        clients.add("amolga@email.com");
        clients.add("cliente@amolga.com");
        clients.add("admin@burger.com");

        // Itens do cardápio de teste
        items.add("Amolga Burger Tradicional - R$ 28,90");
        items.add("Anmolga Cheddar Bacon - R$ 34,90");
        items.add("Batata Frita Suprema - R$ 15,00");
        items.add("Suco Natural de Laranja - R$ 8,00");

        // Histórico de pedidos de teste
        orders.add("Pedido #001 - 1x Amolga Burger Tradicional (sofia@email.com)");
        orders.add("Pedido #002 - 2x Batata Frita Suprema (admin@burger.com)");
    }

    public static void addClients(String client) {
        clients.add(client);
    }

    public static ArrayList<String> getClients() {
        return clients;
    }
    
    public static boolean checkClients(String emailClient) {
        return clients.contains(emailClient);
    }

  
    public static void addPItems(String item) {
        items.add(item);
    }

    public static ArrayList<String> getItems() {
        return items;
    }

    
    public static void addOrders(String order) {
        orders.add(order);
    }

    public static ArrayList<String> getOrders() {
        return orders;
    }
}

