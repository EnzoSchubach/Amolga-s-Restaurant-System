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
    private ArrayList<Order> orders;

    public Kitchen() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void viewOpenOrder() {
        System.out.println("Open orders:");
        for (Order o : orders) {
            if (!o.getStatus().equalsIgnoreCase("Finished")) {
                System.out.println("Pedido ID: " + o.getId());
                System.out.println("Status: " + o.getStatus());
                System.out.println("----------------------");
            }
        }
    }

    public void deliverOrder(Order order) {
        order.finishOrder();
        System.out.println("Order " + order.getId() + " delivered.");
    }
}