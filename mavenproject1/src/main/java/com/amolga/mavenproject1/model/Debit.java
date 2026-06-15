/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;

public class Debit extends PaymentMethod {

    public Debit(double administrativeFee) {
        super(administrativeFee, "Debit");
    }

    @Override
    public double calcValue(double baseValue) {
        return baseValue * (1 + administrativeFee);
    }
}
