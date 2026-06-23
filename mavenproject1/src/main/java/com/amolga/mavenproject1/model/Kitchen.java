/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;
import java.util.*;
/**
 *
 * @author leticiadamata
 */
public class Kitchen {
    
    static private ArrayList<Order> pendingOrders;

    public Kitchen() {
        pendingOrders = new ArrayList<>();
    }

    public void receiveOrder(Order order) {
        pendingOrders.add(order);
    }
    
    public ArrayList<Order> getpendingOrders() {
        return pendingOrders;
    }

    public void deliverOrder(Order order) {
        
        order.finishOrder();
        pendingOrders.remove(order);

        System.out.println("Pedido " + order.getId() + " entregue.");
        

    }
}
