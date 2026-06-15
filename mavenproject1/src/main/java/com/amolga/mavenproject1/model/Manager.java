package com.amolga.mavenproject1.model;

public class Manager {
    
    private Menu mainMenu;
    public Manager(Menu mainMenu){
        this.mainMenu = mainMenu;
    }
    
    public void registerFood(String name, double price, String description){
        MenuItem newItem = new Food(name, price, description);
        this.mainMenu.addItem(newItem);
    }
    
    public void registerDrink(String name, double price, String supplier){
        MenuItem newItem = new Drink(name, price, supplier);
        this.mainMenu.addItem(newItem);
    }
    
    public void removeItem(MenuItem rmvItem){
        this.mainMenu.rmvItem(rmvItem);
    }
    
    public void consultItem(MenuItem consultItem){
        if(this.mainMenu.findItem(consultItem)){
            System.out.println("Nome: " + consultItem.getName() + "\n");
            System.out.println("Tipo: " + consultItem.getType() + "\n");
            System.out.println("Descricao: " + consultItem.getDescription() + "\n");
            System.out.println("Fornecedor: " + consultItem.getSupplier() + "\n");
            System.out.println("Preco: " + consultItem.getPrice() + "\n");
        } else {
            System.out.println("Esse item não está no menu\n");
        }
    }    
    
    public void setMenu(Menu selectedMenu){
        this.mainMenu = selectedMenu;
    }
            
    public Menu getMenu(){
        return this.mainMenu;
    }
}