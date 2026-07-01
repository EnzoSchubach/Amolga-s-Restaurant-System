package com.amolga.mavenproject1.model;
import java.util.*;

public class Manager {
    
    private ArrayList<MenuItem> mainMenu;
    public Manager(ArrayList<MenuItem> mainMenu){
        this.mainMenu = mainMenu;
    }
    
    public void registerFood(String name, double price, String description){
        MenuItem newItem = new Food(name, price, description);
        this.getMainMenu().add(newItem);
    }
    
    public void registerDrink(String name, double price, String supplier){
        MenuItem newItem = new Drink(name, price, supplier);
        this.getMainMenu().add(newItem);
    }
    
    public void removeItem(MenuItem rmvItem){
        this.getMainMenu().remove(rmvItem);
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