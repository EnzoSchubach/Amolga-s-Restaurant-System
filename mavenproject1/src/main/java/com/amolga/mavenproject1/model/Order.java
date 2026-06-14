package com.amolga.mavenproject1.model;
import java.util.ArrayList;

public class Order {

    private int id;
    private ArrayList<Item> itens = new ArrayList<>();
    private String status;
    
    public Order(int id, String status) {

        this.id = id;
        this.status = status;
    
    }
    
    public int getId(){
        return id;
    }

    public ArrayList<Item> getItens(){
        return itens;
    }

    public String getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setItens(ArrayList<Item> itens){
        this.itens = itens;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public void addItem(Item newItem){
        itens.add(newItem);
    }
    
    public void removeItem(Item willDelete){
        itens.remove(willDelete);
    }
    
    public double calculateTotal() {

        double total = 0;
        
        for(Item ip : itens){ 
            total += ip.getPrice(); 
        }
        
        return total;
    
    }
    
    public void finishOrder(){
        status = "Finished";
    }
}