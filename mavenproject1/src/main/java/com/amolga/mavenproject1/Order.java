import java.util.ArrayList;

public class Order {
    private int id;
    private ArrayList<OrderItem> itens = new ArrayList<>();
    private String status;
    
    public Order(int id, String status){
        this.id = id;
        this.status = status;
    }
    
    public int getId(){
        return id;
    }

    public ArrayList<OrderItem> getItens(){
        return itens;
    }

    public String getStatus(){
        return status;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setItens(ArrayList<OrderItem> itens){
        this.itens = itens;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public void addItem(OrderItem newItem){
        itens.add(newItem);
    }
    
    public void removeItem(OrderItem willDelete){
        itens.remove(willDelete);
    }
    
    public double calculateTotal(){
        double total = 0;
        for(OrderItem ip : itens){
            total += ip.calculateSubTotal();
        }
        return total;
    }
    
    public void finishOrder(){
        status = "Finished";
    }
}