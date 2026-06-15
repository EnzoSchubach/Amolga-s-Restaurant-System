/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;

public abstract class PaymentMethod {
    protected double administrativeFee;
    protected String methodName;

    public PaymentMethod(double administrativeFee, String methodName) {
        this.administrativeFee = administrativeFee;
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public double getAdministrativeFee() {
        return administrativeFee;
    }

    public void setAdministrativeFee(double administrativeFee) {
        this.administrativeFee = administrativeFee;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Calcula o valor final da compra considerando a taxa administrativa.
     * 
     * @param baseValue O valor base da compra antes da taxa.
     * @return O valor final após aplicação da taxa.
     */
    public abstract double calcValue(double baseValue);
}
