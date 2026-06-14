package com.amolga.mavenproject1.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private int id;
    private HashMap<MenuItem, Integer> itens;
    private String status;
    
    public Order(int id, String status) {

        this.id = id;
        this.status = status;
        this.itens = new HashMap<>();

    }
    
    public int getId(){
        return id;
    }

    public HashMap<MenuItem, Integer> getItens(){
        return itens;
    }

    public String getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setItens(HashMap<MenuItem, Integer> itens){
        this.itens = itens;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public void addItem(MenuItem newItem) {

        int actualQuantity = itens.getOrDefault(newItem, 1);
        itens.put(newItem, actualQuantity + 1);
    
    }
    
    public void removeItem(MenuItem willDelete){
        itens.remove(willDelete);
    }
    
    public double calculateTotal() {

        double total = 0;

        for (Map.Entry<MenuItem, Integer> item : itens.entrySet()) {
            double itemPrice = item.getKey().getPrice();
            total += itemPrice * item.getValue();
        }

        return total;
    }
    
    public void finishOrder(){
        status = "Finished";
    }
}