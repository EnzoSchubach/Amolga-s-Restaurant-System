/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1;

/**
 *
 * @author mirella
 */

public class OrderItem {
    private ItemCardapio item;
    private int quantity;
    
    public OrderItem(ItemCardapio item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    
    public double calculateSubTotal(){
        return item.getPrice() * quantity;
    }
    
    public ItemCardapio getItem() {
    return item;
    }

    public int getQuantity() {
        return quantity;
    }

}
