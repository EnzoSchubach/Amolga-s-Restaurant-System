package com.amolga.mavenproject1;

public class Manager {
    
    private Menu mainMenu;
    public Manager(Menu mainMenu){
        this.mainMenu = mainMenu;
    }
    
    public void registerItem(String name, String type, String description, String supplier, double price){
        MenuItem newItem = new MenuItem(name, type, description, supplier, price);
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