/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;

/**
 *
 * @author enzoschubach
 */
public class Food extends MenuItem{
    private String description;
    
    public Food(String name, double price, String description){
        super(name, price);
        this.setDescription(description);
    }
    
    public void setDescription(String newDescription){ this.description = newDescription; }
    public String getDescription(){ return this.description; }
}
