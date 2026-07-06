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

    public static void addClients(String client) {
        clients.add(client);
    }

    public static ArrayList<String> getClients() {
        return clients;
    }
    
    public static boolean checkClients(String cpfClient) {
        return clients.contains(cpfClient);
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

