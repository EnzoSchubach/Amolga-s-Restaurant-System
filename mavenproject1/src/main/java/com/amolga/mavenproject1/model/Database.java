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
        clients.add(new Client("Ana Silva", "111.111.111-11", "ana.silva@email.com", "senha123", 50.0));
        clients.add(new Client("Bruno Costa", "222.222.222-22", "bruno.costa@email.com", "bruno456", 20.0));
        clients.add(new Client("Carla Souza", "333.333.333-33", "carla.souza@email.com", "carla789", 0.0));
        clients.add(new Client("Daniel Oliveira", "444.444.444-44", "daniel.oliveira@email.com", "dan1234", 100.0));
        clients.add(new Client("Eduarda Lima", "555.555.555-55", "eduarda.lima@email.com", "duda2024", 30.0));
        clients.add(new Client("Felipe Santos", "666.666.666-66", "felipe.santos@email.com", "felipe321", 0.0));
        clients.add(new Client("Gabriela Alves", "777.777.777-77", "gabriela.alves@email.com", "gabi_2024", 75.0));
        clients.add(new Client("Hugo Pereira", "888.888.888-88", "hugo.pereira@email.com", "hugo987", 10.0));
        clients.add(new Client("Isabela Rocha", "999.999.999-99", "isabela.rocha@email.com", "isa1234", 0.0));
        clients.add(new Client("João Martins", "000.000.000-00", "joao.martins@email.com", "joao555", 60.0));

        // Itens do cardápio de teste
        items.add(new Food("Amolga Classic", 24.90, "Pão, blend de 150g, queijo prato, alface, tomate e maionese artesanal."));
        items.add(new Food("Double Bacon", 32.90, "Pão, dois blends de 120g, cheddar duplo, bacon crocante e molho barbecue."));
        items.add(new Food("Cheddar Monster", 29.90, "Pão brioche, blend de 180g, muito cheddar cremoso e cebola caramelizada."));
        items.add(new Food("Chicken Crispy", 26.90, "Pão brioche, sobrecoxa de frango frita super crocante, alface americana e maionese de alho."));
        items.add(new Food("Veggie Amolga", 27.90, "Pão brioche, hambúrguer de grão-de-bico, queijo prato, rúcula, tomate e maionese verde."));
        items.add(new Food("Smash Simples", 18.00, "Pão, blend smash de 80g, queijo cheddar e ketchup da casa."));
        items.add(new Food("Smash Duplo", 23.00, "Pão, dois blends smash de 80g, queijo cheddar duplo e molho especial."));
        
        items.add(new Food("Patinhas Fritas", 12.00, "Batata frita tradicional bem crocante."));
        items.add(new Food("Patinhas Supremas", 19.90, "Batata frita coberta com cheddar cremoso e bacon picado."));
        items.add(new Food("Onion Rings", 14.00, "Anéis de cebola empanados e fritos, acompanha molho barbecue."));
        items.add(new Food("Nuggets (8 un)", 15.00, "Nuggets de frango crocantes, acompanha molho tártaro."));
        
        items.add(new Drink("Coca-Cola Lata", 6.00, "Coca-Cola Brasil"));
        items.add(new Drink("Guaraná Lata", 6.00, "Ambev"));
        items.add(new Drink("Suco de Laranja", 8.50, "Natural da Fruta"));
        items.add(new Drink("Água Sem Gás", 4.50, "Fontes de Minas"));
        items.add(new Drink("Água Com Gás", 5.00, "Fontes de Minas"));
        items.add(new Drink("Cerveja Heineken", 10.00, "Heineken"));
        items.add(new Drink("Milkshake Chocolate", 16.00, "Sorvete artesanal de chocolate"));
        items.add(new Drink("Milkshake Ovomaltine", 18.00, "Sorvete artesanal com Ovomaltine crocante"));
        items.add(new Drink("Amolga Shake", 18.00, "Sorvete artesanal de frutas"));
        items.add(new Drink("Refresco de Amora", 9.00, "Xarope Monin de amora e água com gás"));

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