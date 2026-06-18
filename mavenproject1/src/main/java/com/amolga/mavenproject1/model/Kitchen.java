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
    
    private ArrayList<Order> pendingOrders;

    public Kitchen() {
        pendingOrders = new ArrayList<>();
    }

    public void receiveOrder(Order order) {
        pendingOrders.add(order);
    }
    
    public ArrayList<Order> getpendingOrders() {
        return pendingOrders;
    }
    
    public void viewOpenOrder() {

        System.out.println("Pedidos abertos:");
        for (Order o : pendingOrders) {
            if (o.getStatus() == OrderStatus.PENDING) {
        System.out.println("Open orders:");
        for (Order o : pendingOrders) {
            if (o.getStatus() != OrderStatus.FINISHED) {
        System.out.println("Open orders:");
        for (Order o : pendingOrders) {
            if (o.getStatus() != OrderStatus.FINISHED) {
                System.out.println("Pedido ID: " + o.getId());
                System.out.println("Status: " + o.getStatus());
                System.out.println("----------------------");
            }
        }
    }

    public void deliverOrder(Order order) {
        
        order.finishOrder();
        pendingOrders.remove(order);

        System.out.println("Pedido " + order.getId() + " entregue.");

        order.finishOrder();
        System.out.println("Order " + order.getId() + " delivered.");

        order.finishOrder();
        System.out.println("Order " + order.getId() + " delivered.");
    }
}
