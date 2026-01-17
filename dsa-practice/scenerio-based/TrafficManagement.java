import java.util.LinkedList;
import java.util.Queue;

class Car{
    int id;
    Car next;
    Car(int id){
        this.id=id;
        this.next=null;
    }
}

class Roundabout{
    public Car head=null;

    public void addCar(int id){
        Car newCar=new Car(id);
        if(head==null){
            head=newCar;
            head.next=head;
        }
        else{
            Car temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newCar;
            newCar.next=head;
        }
        System.out.println("car id = "+id+"enter in roundabout");
    }

    public void removeCar(int id){
        if(head==null){
            System.out.println("no car");
            return;
        }
        Car curr=head;
        Car prev=null;
        do{
            if(curr.id==id){
                if(prev==null){
                    if(head.next==head){
                        head=null;
                    }
                    else{
                        Car temp=head;
                        while(temp.next!=head){
                            temp=temp.next;
                        }
                        head=head.next;
                        temp.next=head;
                    }
                }
                else{
                    prev.next=curr.next;
                }
                System.out.println("car id = "+id+" exit from roundabout");
                return;
            }
            prev=curr;
            curr=curr.next;
        }
        while(curr!=head);
        System.out.println("car not found with id = "+id);
    }


    public void printState(){
        if(head==null){
            System.out.println(" empty roundabout");
            return;
        }

        Car temp=head;
        do{
            System.out.println(temp.id);
            temp=temp.next;
        }
        while(temp!=head);
        System.out.println();
    }
}


public class TrafficManagement {

    public Roundabout r=new Roundabout();
    public Queue<Integer> q;
    public int qc;

    TrafficManagement(int cap){
        this.qc=cap;
        q=new LinkedList<>();
    }

    public void addQue(int id){
        if(q.size()==qc){
            System.out.println("queue overflow");
        }
        else{
            q.add(id);
            System.out.println("id = "+id+" waiting in queue");
        }
    }

    public void allow(){
        if(q.isEmpty()){
            System.out.println("no car waiting");
        }
        else{
            int id=q.poll();
            r.addCar(id);
        }
    }

    public void exit(int id){
        r.removeCar(id);
    }

    public void display(){
        r.printState();
        System.out.println("queue = "+q);
    }

    public static void main(String[] args) {
        TrafficManagement t=new TrafficManagement(3);
        t.addQue(10);
        t.addQue(20);
        t.addQue(30);

        t.allow();
        t.allow();
        t.display();

        t.exit(10);
        t.display();

        t.allow();
        t.display();

    }
}
