package M1_Practice_Problem;

import java.util.*;

class Booking {
    String passengerId;
    int seatCount;
    double bookingFare;

    public Booking(String passengerId, int seatCount, double bookingFare) {
        this.passengerId=passengerId;
        this.seatCount=seatCount;
        this.bookingFare=bookingFare;
    }
}

class Train {
    String trainId;
    String source;
    String destination;
    int totalSeats;
    int availableSeats;
    double baseFare;
    List<Booking> bookings=new ArrayList<>();

    public Train(String trainId, String source, String destination, int totalSeats, double baseFare) {
        this.trainId=trainId;
        this.source=source;
        this.destination=destination;
        this.totalSeats=totalSeats;
        this.baseFare=baseFare;
        this.availableSeats=totalSeats;
    }
}

class RailwayManager {

    List<Train> trainList = new ArrayList<>();

    // ADD TRAIN
    public int addTrain(String trainId, String source, String destination, int totalSeats, double baseFare) {
        for(Train t:trainList){
            if(t.trainId.equals(trainId)){
                return 0;
            }
        }
        Train t=new Train(trainId, source, destination, totalSeats, baseFare);
        trainList.add(t);
        return 0;
    }

    // BOOK
    public int bookSeats(String trainId, String passengerId, int seatCount) {
        double bookingFare=0;
        for(Train t:trainList){
            if(t.trainId.equals(trainId)){
                if(t.availableSeats>=seatCount){
                    bookingFare=(seatCount*t.baseFare)+(seatCount*25);
                    t.availableSeats-=seatCount;
                    System.out.println("BOOKED "+trainId+" "+passengerId+" "+bookingFare);

                    Booking b=new Booking(passengerId, t.availableSeats, bookingFare);
                    t.bookings.add(b);
                    return 1;
                }
                else{
                    System.out.println("Booking failed");
                    return 0;
                }
            }
            else{
                System.out.println("Booking failed");
                return 0;
            }
        }
        return 0;
    }

    // CANCEL
    public int cancelBooking(String trainId, String passengerId) {
        for(Train t:trainList){
            if(t.trainId.equals(trainId)){
                for(int i=0;i<t.bookings.size();i++){
                    Booking b=t.bookings.get(i);
                    if(b.passengerId.equals(passengerId)){
                        t.availableSeats+=b.seatCount;
                        t.bookings.remove(i);
                        System.out.println("CANCELLED "+trainId+" "+passengerId);
                        return 1;
                    }
                }
                System.out.println("Cancellation failed");
                return 0;
            }

        }
        System.out.println("Cancellation failed");
        return 0;
    }

    // ROUTE
    public void findRoute(String source, String destination) {
        int c=0;
        for(Train t:trainList){
            if(t.source.equals(source) && t.destination.equals(destination)){
                System.out.println(t.trainId+" "+t.availableSeats);
                c++;
            }
        }
        if(c==0){
            System.out.println("No trains available");
        }
    }

    // SUMMARY
    public void getRevenueSummary() {
        boolean hasRevenue=false;
        for(Train t:trainList){
            double total=0;
            for(Booking b:t.bookings){
                total+=b.bookingFare;
            }
            if(total>0){
                hasRevenue=true;
            }
            System.out.println(t.trainId+" "+total);
        }
        if(!hasRevenue){
            System.out.println("No revenue generated");
        }
    }
}

public class RailwayDynamicSeatAllocationSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RailwayManager manager = new RailwayManager();

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String command = parts[0];

            switch (command) {

                case "ADDTRAIN": {
                    manager.addTrain(parts[1], parts[2], parts[3], Integer.parseInt(parts[4]),
                            Double.parseDouble(parts[5]));
                    break;
                }

                case "BOOK": {
                    manager.bookSeats(parts[1], parts[2], Integer.parseInt(parts[3]));
                    break;
                }

                case "CANCEL": {
                    manager.cancelBooking(parts[1], parts[2]);
                    break;
                }

                case "ROUTE": {
                    manager.findRoute(parts[1], parts[2]);
                    break;
                }

                case "SUMMARY": {
                    manager.getRevenueSummary();
                    break;
                }
            }
        }
    }
}
