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
public class Cardapio {
    private List<ItemCardapio> items;
    
    public void addItem(){
        
    }
    
    public void rmvItem(){
        
    }
    
    public void findItem(){
        
    }
    
    public void listItems(){
        int cont = 0;
        
        for(ItemCardapio item : items){
            cont++;
            System.out.println("Item n" + cont + ": " + item);
        }
    }
}

