import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Resource{
    private String itemName;
    private int qty;

    public Resource(String itemName, int qty){
        this.itemName=itemName;
        this.qty=qty;
    }

    public String getItemName(){
        return itemName;
    }

    public int getQty(){
        return qty;
    }
}

class AreaRequest{
    private String areaId;
    private String areaName;
    private Map<String, Integer> requestedResource;

    public AreaRequest(String areaId, String areaName, Map<String, Integer> requestedResource){
        this.areaId=areaId;
        this.areaName=areaName;
        this.requestedResource=requestedResource;
    }

    public String getAreaName() {
        return areaName;
    }

    public Map<String, Integer> getRequestedResource() {
        return requestedResource;
    }
}

class InsufficientResourceException extends Exception{
    InsufficientResourceException(String mssg){
        super(mssg);
    }
}

class ReliefCenter{
    private String centerId;
    private String centerName;
    private Map<String, Integer> resources=new HashMap<>();

    public ReliefCenter(String centerId, String centerName){
        this.centerId=centerId;
        this.centerName=centerName;
    }

    public String getCenterName() {
        return centerName;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void addResource(String item, int qty){
        resources.put(item,resources.getOrDefault(qty,0)+1);
    }

    public int getResource(String item){
        return resources.getOrDefault(item,0);
    }

    public void allocateResource(String item, int qty) throws InsufficientResourceException{
        int available=resources.getOrDefault(item, 0);
        if(available<qty) {
            throw new InsufficientResourceException("Insufficient " +item+" in "+centerName);
        }
        resources.put(item, available-qty);
    }
}

class ReliefSystem{
    private Map<String, ReliefCenter> centers=new HashMap<>();
    private Queue<AreaRequest> requests=new LinkedList<>();

    public void registerCenter(ReliefCenter center){
        centers.put(center.getCenterName(), center);
    }

    public void addRequest(AreaRequest request){
        requests.add(request);
    }

    public void allocateResource() throws InsufficientResourceException {
        while (!requests.isEmpty()){
            AreaRequest request=requests.poll();
            System.out.println("Allocate for area: "+request.getAreaName());
            for(Map.Entry<String ,Integer> e:request.getRequestedResource().entrySet()){
                String item=e.getKey();
                int qty=e.getValue();
                boolean allocated=false;
                for(ReliefCenter center:centers.values()){
                    if(center.getResource(item)>=qty){
                        center.allocateResource(item, qty);
                        System.out.println("Allocated "+qty+" "+item+" from "+center.getCenterName());
                        allocated=true;
                        break;
                    }
                }
                if(!allocated){
                    throw new InsufficientResourceException("Request for "+qty+" "+item
                            +" could not be fulfilled");
                }
            }
        }
    }

    public String generateReport() {
        StringBuilder report=new StringBuilder("Allocation Report\n");
        for(ReliefCenter center:centers.values()){
            report.append(center.getCenterName())
                    .append(" Resources: ")
                    .append(center.getResources())
                    .append("\n");
        }
        return report.toString();
    }

}

public class DisasterReliefAllocationSystem{
    public static void main(String[] args) {
        ReliefSystem system = new ReliefSystem();

        ReliefCenter center1 = new ReliefCenter("C1", "Center A");
        center1.addResource("Food", 100);
        center1.addResource("Water", 200);
        center1.addResource("Medical", 50);

        ReliefCenter center2 = new ReliefCenter("C2", "Center B");
        center2.addResource("Food", 150);
        center2.addResource("Water", 100);
        center2.addResource("Medical", 80);

        system.registerCenter(center1);
        system.registerCenter(center2);

        HashMap<String, Integer> req1 = new HashMap<>();
        req1.put("Food", 80);
        req1.put("Water", 150);
        AreaRequest area1 = new AreaRequest("A1", "X", req1);

        HashMap<String, Integer> req2 = new HashMap<>();
        req2.put("Medical", 60);
        req2.put("Food", 120);
        AreaRequest area2 = new AreaRequest("A2", "Y", req2);

        system.addRequest(area1);
        system.addRequest(area2);

        try {
            system.allocateResource();
        }
        catch (InsufficientResourceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(system.generateReport());
    }
}

