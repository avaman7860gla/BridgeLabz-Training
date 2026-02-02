import java.util.*;

// Custom exception
class NoAgentAvailableException extends Exception{
    NoAgentAvailableException(String mssg){
        super(mssg);
    }
}

// Order class
class Order{
    private int orderId;
    private String customerName;
    private String deliveryStatus;
    private String status;

    // Constructor
    public Order(int orderId, String customerName, String deliveryStatus){
        this.orderId=orderId;
        this.customerName=customerName;
        this.deliveryStatus=deliveryStatus;
        this.status="Pending";
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public String getStatus() {
        return status;
    }

    // Setter
    public void setStatus(String status) {
        this.status = status;
    }
}

// Agent class
class Agent{
    private int agentId;
    private String name;
    private String location;
    private boolean available;

    // Constructor
    public Agent(int agentId, String name, String location){
        this.agentId=agentId;
        this.name=name;
        this.location=location;
        this.available=true;
    }

    // Getters
    public int getAgentId() {
        return agentId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    // Setter
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Method to check agent is available or not
    public boolean isAvailable(){
        return available;
    }
}

// Delivery service class
class DeliveryService{
    private Queue<Order> orders=new LinkedList<>();
    private List<Agent> agents=new ArrayList<>();
    private Map<Order, Agent> activeDeliveries=new HashMap<>();

    // Maethod to add order
    public void addOrder(Order order){
        orders.add(order);
        System.out.println("Order Added: "+order.getOrderId());
    }

    // Method to cancel order
    public void cancelOrder(int orderId){
        Order toCancel=null;
        for(Order o:activeDeliveries.keySet()){
            if(o.getOrderId()==orderId){
                toCancel=o;
                break;
            }
        }
        if(toCancel!=null){
            Agent agent=activeDeliveries.get(toCancel);
            agent.setAvailable(true);
            toCancel.setStatus("Cancelled");
            activeDeliveries.remove(toCancel);
            System.out.println("Cancelled order: "+orderId);
        }
        else{
            System.out.println("Order not found");
        }
    }

    // Method to add agent
    public void addAgent(Agent agent){
        agents.add(agent);
        System.out.println("Agent added: "+agent.getAgentId());
    }

    // Method to assign order
    public void assignOrder() throws NoAgentAvailableException{
        if(orders.isEmpty()){
            System.out.println("No orders");
            return;
        }
        Order order=orders.poll();
        Agent agent=findNearestAgent(order);

        if(agent==null){
            throw new NoAgentAvailableException("No agent available for: "+order.getOrderId());
        }
        agent.setAvailable(false);
        order.setStatus("Assigned");
        activeDeliveries.put(order, agent);
        System.out.println("Assigned "+order.getOrderId()+" to "+agent.getName());
    }

    // Method to find nearest available agent
    public Agent findNearestAgent(Order order){
        for(Agent agent:agents){
            if(agent.isAvailable()){
                return agent;
            }
        }
        return null;
    }

    // Method to view active deliveries
    public void viewActiveDeliveries(){
        if(activeDeliveries.isEmpty()){
            System.out.println("No active deliveries");
        }
        else{
            for(Map.Entry<Order, Agent> e:activeDeliveries.entrySet()){
                System.out.println(e.getKey().getOrderId()+" - "+e.getValue().getName());
            }
        }
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {

        DeliveryService service=new DeliveryService();

        // Add agents
        service.addAgent(new Agent(1,"Aman","Agra"));
        service.addAgent(new Agent(2,"Neha", "Delhi"));

        // Add orders
        service.addOrder(new Order(101,"Rahul", "Noida"));
        service.addOrder(new Order(102,"Riya", "Gurgaon"));

        try{
            service.assignOrder();
            service.assignOrder();
        }
        catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.viewActiveDeliveries();

        // Cancel order
        service.cancelOrder(101);
        
        service.viewActiveDeliveries();
    }
}
