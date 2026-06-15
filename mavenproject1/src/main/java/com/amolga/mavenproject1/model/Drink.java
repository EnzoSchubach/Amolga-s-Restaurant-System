/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;

/**
 *
 * @author enzoschubach
 */
public class Drink extends MenuItem {
    private String supplier;
    
    Drink(String name, double price, String supplier){
        super(name, price);
        this.setSupplier(supplier);
    }
    
    public void setSupplier(String newSupplier){ this.supplier = newSupplier; }
    public String getSupplier(){ return this.supplier; }
}
