package com.amolga.mavenproject1.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private int id;
    private HashMap<MenuItem, Integer> items;
    private OrderStatus status;
    
    public Order(int id, String status) {

        this.id = id;
        this.status = status;
        this.items = new HashMap<>();
        this.status = OrderStatus.PENDING;
    
    }
    
    public int getId(){
        return id;
    }

    public HashMap<MenuItem, Integer> getItens(){
        return items;
    }

    public String getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setItens(HashMap<MenuItem, Integer> items){
        this.items = items;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public void addItem(MenuItem newItem) {

        int actualQuantity = items.getOrDefault(newItem, 1);
        items.put(newItem, actualQuantity + 1);
    
    }
    
    public void removeItem(MenuItem willDelete){
        items.remove(willDelete);
    }
    
    public double calculateTotal() {

        double total = 0;

        for (Map.Entry<MenuItem, Integer> item : items.entrySet()) {
            double itemPrice = item.getKey().getPrice();
            total += itemPrice * item.getValue();
        }

        return total;
    }
    
    public void finishOrder(){ 
        status = OrderStatus.FINISHED; 
    }
    
    public void deliveredOrder() { 
        status = OrderStatus.DELIVERED; 
    }

}