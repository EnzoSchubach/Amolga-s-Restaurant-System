package com.amolga.mavenproject1.model;
import java.util.*;

public class Bill {
    private Client client;
    private Table table;
    private ArrayList<Order> orders = new ArrayList<>();

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    public Table getTable() {
        return table;
    }
    public void setTable(Table table) {
        this.table = table;
    }

    public void resgiter(String name, String cpf, String email, double bonus){
        client.setName(name);
        client.setCpf(cpf);
        client.setEmail(email);
        client.setBonus(0);
    }
    
    public void alterInfo(){
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
                    client.setName(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Escreva o novo cpf");
                    client.setCpf(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Escreva o novo email");
                    client.setEmail(sc.nextLine());
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
      
    public void excludeClient(){
        client.setName(null);
        client.setCpf(null);
        client.setEmail(null);
        client.setBonus(0);
    }
    
    public void consultClient(){
        System.out.println("Nome: " + client.getName());
        System.out.println("Cpf: " + client.getCpf());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Bonus: " + client.getBonus());
    }
    
}
