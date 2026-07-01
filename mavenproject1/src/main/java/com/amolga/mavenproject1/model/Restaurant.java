/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;

/**
 *
 * @author sofia macedo
 */
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Client> clients;
    private List<Table> tables;
    private List<Order> openOrders;
    private List<MenuItem> menu;
    private Manager manager;
    
    public Restaurant() {
        this.clients = new ArrayList<>();
        this.tables = new ArrayList<>();
        this.openOrders = new ArrayList<>();
        this.menu = new ArrayList<>();
    }
    
    public Restaurant(List<Client> clients, List<Table> tables, List<Order> openOrders, List<MenuItem> menu, Manager manager) {
        this.clients = clients;
        this.tables = tables;
        this.openOrders = openOrders;
        this.menu = menu;
        this.manager = manager;
    }
    
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Order> getOpenOrders() {
        return openOrders;
    }

    public void setOpenOrders(List<Order> openOrders) {
        this.openOrders = openOrders;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}

