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

public class Manager {
    private int id;
    private String password;
    
    private Restaurant restaurant;
    
    public Manager(int id, String password, Restaurant restaurant){
        this.id = id;
        this.password = password;
        this.restaurant = restaurant;
    }
    
    public void registerItem(String name, String type, String description, String supplier, double price){
        MenuItem newItem = null;
        
        if (type.equalsIgnoreCase("Food")) {
            newItem = new Food(name, price, description);
        } else if (type.equalsIgnoreCase("Drink")) {
            newItem = new Drink(name, price, supplier);
        }
        
        if (newItem != null) {
            this.restaurant.getMenu().add(newItem);
            System.out.println("Item cadastrado.");
        } else {
            System.out.println("Não reconhecido. Escolha 'Food' ou 'Drink'");
        }
    }
    
    public void removeItem(MenuItem rmvItem){
        ArrayList<MenuItem> menuAtual = this.restaurant.getMenu();
        if (menuAtual.contains(rmvItem)) {
            menuAtual.remove(rmvItem);
            System.out.println("Item removido.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }
    
public void consultItem(MenuItem consultItem){
        if (this.restaurant.getMenu().contains(consultItem)){
            System.out.println("Nome: " + consultItem.getName());
            System.out.println("Preço: " + consultItem.getPrice());
            System.out.println("Quantidade: " + consultItem.getQuantity());
            
            if(consultItem instanceof Food) {
                Food f = (Food) consultItem;
                System.out.println("Tipo: Food");
                System.out.println("Descrição: " + f.getDescription());
            } else if (consultItem instanceof Drink) {
                Drink d = (Drink) consultItem; 
                System.out.println("Tipo: Drink");
                System.out.println("Fornecedor: " + d.getSupplier()); 
            }
            System.out.println();
        } else {
            System.out.println("Item não encontrado.");
        }
    }
   
    public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
        public Restaurant getRestaurant() {
        return this.restaurant; 
    }
        
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
