/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1;
import java.util.*;
/**
 *
 * @author leticiadamata
 */
public class Client {
    private String name, cpf, email;
    private double bonus;
    
    public String getName(){
        return this.name;
    }
    
    private void setName(String name){
        this.name = name;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    private void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    private void setEmail(String email){
        this.email = email;
    }
    
    public double getBonus(){
        return this.bonus;
    }
    
    private void setBonus(double bonus){
        this.bonus = bonus;
    }
    
    public Client(String name, String cpf, String email, double bonus){
        this.setName(name);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setBonus(bonus);
    }
    
    public void resgiter(String name, String cpf, String email, double bonus){
        setName(name);
        setCpf(cpf);
        setEmail(email);
        setBonus(0);
    }
    
    public void alterRegister(){
        System.out.println("O que deseja alterar?");
        boolean finalizado = false;
        Scanner sc = new Scanner(System.in);
        int option;
        while(finalizado == false){
            System.out.println("1: nome\n2: cpf\n3: email");
            option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.println("Escreva o novo nome");
                    setName(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Escreva o novo cpf");
                    setCpf(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Escreva o novo email");
                    setEmail(sc.nextLine());
                    break;
                default:
                    break;
            }
            System.out.println("Deseja alterar mais alguma coisa?");
            System.out.println("1: Sim\n2: Não");
            int response = sc.nextInt();
            if(response == 2) finalizado = true;
        }
    }
      
    public void excludeRegister(){
        setName(null);
        setCpf(null);
        setEmail(null);
        setBonus(0);
    }
    
    public void consultRegister(){
        System.out.println("Nome: " + getName());
        System.out.println("Cpf: " + getCpf());
        System.out.println("Email: " + getEmail());
        System.out.println("Bonus: " + getBonus());
    }
    
}
