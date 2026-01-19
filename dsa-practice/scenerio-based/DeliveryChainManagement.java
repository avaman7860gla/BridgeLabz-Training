import java.util.Map;
import java.util.HashMap;

class StageNode{
    private String stageName;
    private StageNode next;

    public StageNode(String stageName){
        this.stageName=stageName;
        this.next=null;
    }

    public String getStageName(){
        return stageName;
    }

    public StageNode getNext(){
        return next;
    }

    public void setNext(StageNode next){
        this.next=next;
    }
}

interface TrackingOps{
    public void addStage(String stageName);
    public void insertCheckpoint(String prevStage, String newStage);
    public void trackForward();
    public void markLost(String stageName);
    public String getCurrStage();
}

class ParcelTracker implements TrackingOps{
    private StageNode head;
    private StageNode curr;

    public ParcelTracker(){
        this.head=null;
        this.curr=null;
    }

    @Override
    public void addStage(String stageName){
        StageNode newNode=new StageNode(stageName);
        if(head==null){
            head=newNode;
            curr=head;
        }
        else{
            StageNode temp=head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    @Override
    public void insertCheckpoint(String prevStage, String newStage){
        StageNode newNode=new StageNode(newStage);
        StageNode temp=head;
        while(temp!=null && !temp.getStageName().equals(prevStage)){
            temp=temp.getNext();
        }
        if(temp!=null){
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    @Override
    public void trackForward(){
        if(curr!=null && curr.getNext()!=null){
            curr=curr.getNext();
        }
    }

    @Override
    public void markLost(String stageName){
        StageNode temp=head;
        while(temp!=null){
            if(temp.getStageName().equals(stageName)){
                System.out.println("Parcel lost at stage: "+stageName);
                return;
            }
            temp=temp.getNext();
        }
        System.out.println("Stage not found");
    }

    @Override
    public String getCurrStage(){
        if(curr!=null){
            return curr.getStageName();
        }
        else{
            return "No current stage";
        }
    }

    public void displayChain(){
        StageNode temp=head;
        while(temp!=null){
            System.out.print(temp.getStageName()+" -> ");
            temp=temp.getNext();
        }
        System.out.print("null");
        System.out.println();
    }
}

class DeliverySystem{
    private Map<String, ParcelTracker> parcels;

    public DeliverySystem(){
        parcels=new HashMap<>();
    }

    public void addParcel(String parcelId, ParcelTracker tracker){
        parcels.put(parcelId, tracker);
        System.out.println("Parcel added: "+parcelId);
    }

    public ParcelTracker getParcelTracker(String parcelId){
        return parcels.get(parcelId);
    }

    public void trackParcel(String parcelId){
        ParcelTracker tracker=parcels.get(parcelId);
        if(tracker!=null){
            System.out.println("Current stage of parcel: "+tracker.getCurrStage());
        }
        else{
            System.out.println("Parcel not found");
        }
    }

    public void marlParcelLost(String parcelId, String stageName){
        ParcelTracker tracker=parcels.get(parcelId);
        if(tracker!=null){
            tracker.markLost(stageName);
        }
        else{
            System.out.println("Parcel not found");
        }
    }
}


public class DeliveryChainManagement {
    public static void main(String[] args) {
        
        DeliverySystem deliverySystem=new DeliverySystem();

        ParcelTracker parcel1=new ParcelTracker();
        parcel1.addStage("Warehouse");
        parcel1.addStage("In Transit");
        parcel1.addStage("Out for Delivery");
        parcel1.addStage("Delivered");

        deliverySystem.addParcel("P123", parcel1);

        deliverySystem.trackParcel("P123");
        parcel1.trackForward();
        deliverySystem.trackParcel("P123");

        parcel1.insertCheckpoint("In Transit", "Customs Check");
        parcel1.displayChain();

        deliverySystem.marlParcelLost("P123", "Customs Check");
    }
}
