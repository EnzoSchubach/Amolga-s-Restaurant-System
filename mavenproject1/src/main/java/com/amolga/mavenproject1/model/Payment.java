package com.amolga.mavenproject1.model;
import java.time.LocalDateTime;


public class Payment {
    private Order order;
    private Client client;
    private Table table;
    private PaymentMethod paymentMethod;
    private LocalDateTime dateTime;

    public Payment(Order order, Client client, Table table, PaymentMethod paymentMethod) {
        this.order = order;
        this.client = client;
        this.table = table;
        this.paymentMethod = paymentMethod;
        this.dateTime = LocalDateTime.now();
    }

    public void processPayment() {
        double total = order.calculateTotal();
        
        if (client.getBonus() > 0) {
            total -= client.getBonus();
        }

        // Calculates the final total by applying the specific fee of the payment method
        double finalTotal = paymentMethod.calcValue(total);

        order.finishOrder();
        table.freeTable();

        displayReceipt(finalTotal);
    }

    private void displayReceipt(double finalAmount) {
        System.out.println("======= PAYMENT RECEIPT =======");
        System.out.println("Date/Time: " + dateTime);
        System.out.println("Customer: " + client.getName());
        System.out.println("Table Number: " + table.getNumber());
        System.out.println("Method: " + paymentMethod.getMethodName());
        System.out.println("Final Total: R$ " + finalAmount);
        System.out.println("Order Status: " + order.getStatus());
        System.out.println("Table Status: " + table.getStatus());
        System.out.println("===============================");
    }

    //getters
    public Order getOrder() { return order; }
    public Client getClient() { return client; }
    public Table getTable() { return table; }
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public LocalDateTime getDateTime() { return dateTime; }

    //setters
    public void setOrder(Order order) {
        this.order = order;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
