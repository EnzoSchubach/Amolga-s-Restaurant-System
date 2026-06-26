package com.amolga.mavenproject1.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    static private int orderId = 1;
    private int id;
    private HashMap<MenuItem, Integer> items;
    private OrderStatus status;
    
    public Order() {

        this.id = orderId++;
        this.items = new HashMap<>();
        this.status = OrderStatus.PENDING;
    
    }
    
    public int getId(){
        return id;
    }

    public HashMap<MenuItem, Integer> getItems(){
        return items;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setItens(HashMap<MenuItem, Integer> items){
        this.items = items;
    }
    
    public void finishOrder(){ 
        status = OrderStatus.FINISHED; 
    }
    
    public void deliveredOrder() { 
        status = OrderStatus.DELIVERED; 
    }

    public void pendingOrder() {
        status = OrderStatus.PENDING;
    }

    public void addItem(MenuItem newItem) {

        int actualQuantity = items.getOrDefault(newItem, 0);
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
    

}