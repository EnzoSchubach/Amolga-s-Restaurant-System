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
public class Client {
    private String name, cpf, email, password;
    private double bonus;
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public double getBonus(){
        return this.bonus;
    }
    
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    
    public Client(String name, String cpf, String email, String password, double bonus){
        this.setName(name);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setBonus(bonus);
        this.setPassword(password);
    }
    
    public void checkBonus(){
        System.out.println("Bonus: " + getBonus());
    }
    
    public void printInfo(){
        System.out.println("Nome: " + getName());
        System.out.println("CPF: " + getCpf());
        System.out.println("Email: " + getEmail());
    }
    
}
