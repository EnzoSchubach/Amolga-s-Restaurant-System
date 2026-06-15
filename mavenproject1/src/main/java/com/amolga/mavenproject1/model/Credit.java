/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;


public class Credit extends PaymentMethod {
    private boolean isInInstallments;

    public Credit(boolean isInInstallments, double administrativeFee) {
        super(administrativeFee, "Credit");
        this.isInInstallments = isInInstallments;
    }

    public boolean isInInstallments() {
        return isInInstallments;
    }

    public void setInInstallments(boolean isInInstallments) {
        this.isInInstallments = isInInstallments;
    }

    @Override
    public double calcValue(double baseValue) {
        double effectiveFee = isInInstallments ? (administrativeFee + 0.02) : administrativeFee;
        return baseValue * (1 + effectiveFee);
    }
}
