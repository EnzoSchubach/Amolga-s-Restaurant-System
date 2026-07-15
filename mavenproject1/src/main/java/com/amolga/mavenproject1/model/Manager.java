/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;
import java.util.*;

/**
 *
 * @author sofia macedo
 */

import java.util.ArrayList;

public class Manager {
    private int id;
    private String password;
    private Database database;
    
    public Manager(int id, String password, Database database){
        this.id = id;
        this.password = password;
        this.database = database;
    }
    
    public void registerItem(String name, String type, String description, String supplier, double price){
        MenuItem newItem = null;
        
        if (type.equalsIgnoreCase("Food")) {
            newItem = new Food(name, price, description);
        } else if (type.equalsIgnoreCase("Drink")) {
            newItem = new Drink(name, price, supplier);
        }
        
        if (newItem != null) {
            this.database.getItems().add(newItem);
            System.out.println("Item cadastrado.");
        } else {
            System.out.println("Não reconhecido. Escolha 'Food' ou 'Drink'");
        }
    }
    
    public void removeItem(MenuItem rmvItem){
        List<MenuItem> menuAtual = (this.database != null) ? this.database.getItems() : this.mainMenu;
        if (menuAtual != null && menuAtual.contains(rmvItem)) {
            menuAtual.remove(rmvItem);
            Database.removePItems(rmvItem);
            System.out.println("Item removido.");
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
    
    public Database getDatabase() {
        return this.database; 
    }
        
    public void setDatabase(Database database) {
        this.database = database;
    }


    private ArrayList<MenuItem> mainMenu;
    public Manager(ArrayList<MenuItem> mainMenu){
        this.mainMenu = mainMenu;
    }
    
    public void registerFood(String name, double price, String description){
        MenuItem newItem = new Food(name, price, description);
        this.getMainMenu().add(newItem);
        Database.addPItems(newItem);
    }
    
    public void registerDrink(String name, double price, String supplier){
        MenuItem newItem = new Drink(name, price, supplier);
        this.getMainMenu().add(newItem);
        Database.addPItems(newItem);
    }
    
    
    public void consultItem(String consultItem){
        for(MenuItem item : getMainMenu()){
            if(item.getName().equalsIgnoreCase(consultItem)){
                System.out.println("Nome: " + item.getName());
                System.out.println("Preco: " + item.getPrice());
                return;
            }
        }
        System.out.println("Esse item não está no menu");
    }    

    public ArrayList<MenuItem> getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(ArrayList<MenuItem> mainMenu) {
        this.mainMenu = mainMenu;
    }

}
