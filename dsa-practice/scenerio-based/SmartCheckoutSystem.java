import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Item{
    private String itemId;
    private String name;
    private double price;
    private int stock;

    // constructor
    public Item(String itemId, String name, double price, int stock){
        this.itemId=itemId;
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    // getters
    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // setter
    public void setStock(int stock){
        this.stock=stock;
    }
}

class Customer{
    private int customerId;
    private String name;
    private List<String> itemIds;

    // constructor
    public Customer(int customerId, String name, List<String> itemIds){
        this.customerId=customerId;
        this.name=name;
        this.itemIds=itemIds;
    }

    // getters
    public int getCustomerId() {
        return customerId;
    }
    
    public String getName() {
        return name;
    }

    public List<String> getItemIds() {
        return itemIds;
    }
}

class CheckoutCounter{
    private Queue<Customer> queue;
    private HashMap<String, Item> inventory;

    // constructor
    public CheckoutCounter(){
        queue=new LinkedList<>();
        inventory=new HashMap<>();
    }

    // to add customers
    public void addCustomer(Customer customer){
        queue.add(customer);
        System.out.println(customer.getName()+" added customer");
    }

    // to remove customers
    public Customer removeCustomer(){
        Customer removed=queue.poll();
        if(removed!=null){
            System.out.println(removed.getName()+" removed");
        }
        return removed;
    }

    // to fetch price
    public double fetchPrice(String itemId){
        Item item=inventory.get(itemId);
        if(item!=null){
            return item.getPrice();
        }
        return -1;
    }

    // to update stock 
    public void updateStock(String itemId, int qty){
        Item item=inventory.get(itemId);
        if (item!=null && item.getStock()>=qty){ 
            item.setStock(item.getStock()-qty); 
            System.out.println("Stock updated for " +item.getName()+ ", Remaining " +item.getStock()); 
        }
        else{ 
            System.out.println("Insufficient stock for " +itemId); 
        }
    }

    // to add items in inventory
    public void addItemToInventory(Item item){
        inventory.put(item.getItemId(), item);
        System.out.println("Item added to inventory having itemID: "+item.getItemId());
    }

    // to process purchase and generate bill
    public void processPurchase(){
        Customer customer=queue.peek();
        if(customer==null){
            System.out.println("No Customer");
            return;
        }

        double totalBill=0;
        System.out.println("Processing purchase for "+customer.getName()); 
        for (String itemId:customer.getItemIds()){ 
            Item item=inventory.get(itemId); 
            if (item!=null && item.getStock()>0){ 
                totalBill+=item.getPrice(); 
                updateStock(itemId, 1); 
                System.out.println("Bought: " + item.getName() + " for " + item.getPrice()); 
            } 
            else{ 
                System.out.println("Item " + itemId + " is out of stock"); 
            } 
        } 
        System.out.println("Total Bill for " +customer.getName()+ ": " + totalBill);
        removeCustomer();
    }

}

public class SmartCheckoutSystem {
    public static void main(String[] args) {
        CheckoutCounter counter = new CheckoutCounter(); 
        // add items to inventory 
        counter.addItemToInventory(new Item("I001", "Milk", 50.0, 10)); 
        counter.addItemToInventory(new Item("I002", "Bread", 30.0, 5)); 
        counter.addItemToInventory(new Item("I003", "Eggs", 6.0, 20)); 

        // add customers 
        counter.addCustomer(new Customer(1, "Aman", Arrays.asList("I001", "I002"))); 
        counter.addCustomer(new Customer(2, "Riya", Arrays.asList("I003", "I003", "I001"))); 
        
        // process purchases 
        counter.processPurchase(); 
        counter.processPurchase();
    }
}
