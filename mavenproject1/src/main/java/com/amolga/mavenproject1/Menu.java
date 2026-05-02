/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1;

import java.util.*;

/**
 *
 * @author enzoschubach
 */
public class Menu {
    private List<MenuItem> items;
    
    public Menu(){
        this.items = new ArrayList<>();
    }
    
    public void addItem(MenuItem newItem){
        this.items.add(newItem);
    }
    
    public void rmvItem(MenuItem rmvItem){
        this.items.remove(rmvItem);
    }
    
    public boolean findItem(MenuItem findItem){
        boolean in_cardapio = false;
        
        for(MenuItem item : items){
            if(findItem.equals(item)) in_cardapio = true; break;
        }
        
        return in_cardapio; 
    }
    
    public void listItems(){
        int cont = 0;
        
        for(MenuItem item : items){
            cont++;
            System.out.println("Item n" + cont + ": " + item);
        }
    }
}

