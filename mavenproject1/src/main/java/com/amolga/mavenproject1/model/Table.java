/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;

/**
 *
 * @author leticiadamata
 */
public class Table {
    private int number;
    private TableStatus status;
    private String code;
       
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
    
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public Table(int number){
        setNumber(number);
        setStatus(TableStatus.FREE);
        this.code = null;
    }
    
    public void occupyTable(String code){
        if(status == TableStatus.FREE) {
            status = TableStatus.OCCUPIED;
            this.code = code;
        }
    }
    
    public void freeTable(){
        this.status = TableStatus.FREE;
        this.code = null;
    }
}
