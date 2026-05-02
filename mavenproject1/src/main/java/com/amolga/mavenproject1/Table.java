/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1;

/**
 *
 * @author leticiadamata
 */
public class Table {
    private int number;
    private TableStatus status;
       
    public int getNumber(){
        return this.number;
    }
    
    private void setNumber(int number){
        this.number = number;
    }
    
    public TableStatus getStatus(){
        return this.status;
    }
    
    private void setStatus(TableStatus status){
        this.status = status;
    }
    
    public Table(int number){
        setNumber(number);
        setStatus(TableStatus.FREE);
    }
    
    public void occupyTable(){
        if(status ==TableStatus.FREE) status = TableStatus.OCCUPIED;
    }
    
    public void freeTable(){
        this.status = TableStatus.FREE;
    }
}
