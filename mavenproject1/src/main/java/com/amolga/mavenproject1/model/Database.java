/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amolga.mavenproject1.model;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sofia macedo
 */

public class Database {
    private static final ArrayList<Client> clients = new ArrayList<>();
    private static final ArrayList<MenuItem> items = new ArrayList<>();
    private static final ArrayList<Order> orders = new ArrayList<>();
    private static final ArrayList<Table> tables = new ArrayList<>();
    private static final ArrayList<Bill> activeBills = new ArrayList<>();
    
    static {
        // Inicializa as 13 mesas do restaurante
        for (int i = 1; i <= 13; i++) {
            tables.add(new Table(i));
        }

        // Clientes de teste
        clients.add(new Client("Amolga Administrador", "amolga@email.com", "senha123", "(11) 99999-9999", 0.0));
        clients.add(new Client("Cliente Padrão", "cliente@amolga.com", "123456", "(11) 88888-8888", 50.0));
        clients.add(new Client("Admin Burger", "admin@burger.com", "admin123", "(11) 77777-7777", 150.50));

        // Itens do cardápio de teste
        // Burgers (Hambúrgueres)
        items.add(new Food("Amolga Classic", 24.90, "Pão, blend de 150g, queijo prato, alface, tomate e maionese artesanal."));
        items.add(new Food("Double Bacon", 32.90, "Pão, dois blends de 120g, cheddar duplo, bacon crocante e molho barbecue."));
        items.add(new Food("Cheddar Monster", 29.90, "Pão brioche, blend de 180g, muito cheddar cremoso e cebola caramelizada."));
        items.add(new Food("Chicken Crispy", 26.90, "Pão brioche, sobrecoxa de frango frita super crocante, alface americana e maionese de alho."));
        items.add(new Food("Veggie Amolga", 27.90, "Pão brioche, hambúrguer de grão-de-bico, queijo prato, rúcula, tomate e maionese verde."));
        items.add(new Food("Smash Simples", 18.00, "Pão, blend smash de 80g, queijo cheddar e ketchup da casa."));
        items.add(new Food("Smash Duplo", 23.00, "Pão, dois blends smash de 80g, queijo cheddar duplo e molho especial."));
        
        // Acompanhamentos (Sides)
        items.add(new Food("Batata Frita", 12.00, "Batata frita tradicional bem crocante."));
        items.add(new Food("Batata Suprema", 19.90, "Batata frita coberta com cheddar cremoso e bacon picado."));
        items.add(new Food("Onion Rings", 14.00, "Anéis de cebola empanados e fritos, acompanha molho barbecue."));
        items.add(new Food("Nuggets (8 un)", 15.00, "Nuggets de frango crocantes, acompanha molho tártaro."));
        
        // Bebidas (Drinks)
        items.add(new Drink("Coca-Cola Lata", 6.00, "Coca-Cola Brasil"));
        items.add(new Drink("Guaraná Lata", 6.00, "Ambev"));
        items.add(new Drink("Suco de Laranja", 8.50, "Natural da Fruta"));
        items.add(new Drink("Água Sem Gás", 4.50, "Fontes de Minas"));
        items.add(new Drink("Água Com Gás", 5.00, "Fontes de Minas"));
        items.add(new Drink("Cerveja Heineken", 10.00, "Heineken"));
        items.add(new Drink("Milkshake Chocolate", 16.00, "Sorvete artesanal de chocolate"));
        items.add(new Drink("Milkshake Ovomaltine", 18.00, "Sorvete artesanal com Ovomaltine crocante"));
        items.add(new Drink("Soda Italiana Limão", 9.00, "Xarope Monin e água com gás"));

        // // Histórico de pedidos de teste (Instanciando vazio, pois não exige argumentos)
        orders.add(new Order());
        orders.add(new Order());
    }

    public static void addClients(Client client) {
        clients.add(client);
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }
    
    public static boolean checkClients(String emailClient) {
        for (Client c : clients) {
            if (c.getEmail().equalsIgnoreCase(emailClient)) {
                return true;
            }
        }
        return false;
    }

    public static void addPItems(MenuItem item) {
        items.add(item);
    }

    public static void removePItems(MenuItem item) {
        items.remove(item);
    }

    public static ArrayList<MenuItem> getItems() {
        return items;
    }

    public static void addOrders(Order order) {
        orders.add(order);
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static ArrayList<Table> getTables() {
        return tables;
    }

    public static Table getTableByNumber(int number) {
        for (Table t : tables) {
            if (t.getNumber() == number) {
                return t;
            }
        }
        return null;
    }

    public static String generateUniqueTableCode() {
        Random random = new Random();
        String newCode;
        boolean exists;
        do {
            newCode = String.format("%04d", random.nextInt(10000));
            exists = false;
            for (Table t : tables) {
                if (t.getStatus() == TableStatus.OCCUPIED && newCode.equals(t.getCode())) {
                    exists = true;
                    break;
                }
            }
        } while (exists);
        return newCode;
    }

    public static Table occupyTable(int number) {
        Table t = getTableByNumber(number);
        if (t != null && t.getStatus() == TableStatus.FREE) {
            String uniqueCode = generateUniqueTableCode();
            t.occupyTable(uniqueCode);
            return t;
        }
        return null;
    }

    public static void freeTable(int number) {
        Table t = getTableByNumber(number);
        if (t != null) {
            t.freeTable();
        }
    }

    public static ArrayList<Bill> getActiveBills() {
        return activeBills;
    }

    public static void addActiveBill(Bill bill) {
        activeBills.add(bill);
    }

    public static void removeActiveBill(Bill bill) {
        activeBills.remove(bill);
    }

    public static Bill getActiveBillByTable(int tableNumber) {
        for (Bill b : activeBills) {
            if (b.getTable() != null && b.getTable().getNumber() == tableNumber) {
                return b;
            }
        }
        return null;
    }

    public static Bill getActiveBillByClient(Client client) {
        if (client == null) return null;
        for (Bill b : activeBills) {
            if (b.getClient() != null && client.getEmail().equalsIgnoreCase(b.getClient().getEmail())) {
                return b;
            }
        }
        return null;
    }
}