/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;

import java.util.*;

/**
 *
 * @author enzoschubach
 */
public class Menu {
    private List<Item> items;
    
    public Menu(){
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item newItem){
        this.items.add(newItem);
    }
    
    public void rmvItem(Item rmvItem){
        this.items.remove(rmvItem);
    }
    
    public boolean findItem(Item findItem){
        boolean in_cardapio = false;
        
        for(Item item : items){
            if(findItem.equals(item)) in_cardapio = true; break;
        }
        
        return in_cardapio; 
    }
    
    public void listItems(){
        int cont = 0;
        
        for(Item item : items){
            cont++;
            System.out.println("Item n" + cont + ": " + item);
        }
    }
}

