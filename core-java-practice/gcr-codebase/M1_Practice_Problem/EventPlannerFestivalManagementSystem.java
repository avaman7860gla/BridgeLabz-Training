package M1_Practice_Problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Festival{
    String name;
    String location;
    String date;
    Festival(String name, String location, String date){
        this.name=name;
        this.location=location;
        this.date=date;
    }

    abstract void displayDetails();
}

class Music extends Festival{
    String headliner;
    String musicGenre;
    int ticketPrice;

    Music(String name, String location, String date, String headliner, String musicGenre, int ticketPrice){
        super(name, location, date);
        this.headliner=headliner;
        this.musicGenre=musicGenre;
        this.ticketPrice=ticketPrice;
    }

    @Override
    void displayDetails() {
        System.out.println("Festival Name: " +name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Headliner: "+headliner);
        System.out.println("Music Genre: "+musicGenre);
        System.out.println("Ticket Price: "+ticketPrice);
    }
}

class Food extends Festival{
    String cuisine;
    int numStalls;
    int entryFee;

    Food(String name, String location, String date, String cuisine, int numStalls, int entryFee){
        super(name, location, date);
        this.cuisine=cuisine;
        this.numStalls=numStalls;
        this.entryFee=entryFee;
    }

    @Override
    void displayDetails() {
        System.out.println("Festival Name: " +name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Cuisine: "+cuisine);
        System.out.println("Number of Stalls: "+numStalls);
        System.out.println("Entry Fee: "+entryFee);
    }
}

class Art extends Festival{
    String artType;
    int numArtists;
    int exhibitionFee;

    Art(String name, String location, String date, String artType, int numArtists, int exhibitionFee){
        super(name, location, date);
        this.artType=artType;
        this.numArtists=numArtists;
        this.exhibitionFee=exhibitionFee;
    }

    @Override
    void displayDetails() {
        System.out.println("Festival Name: " +name);
        System.out.println("Location: "+location);
        System.out.println("Date: "+date);
        System.out.println("Art Type: "+artType);
        System.out.println("Number of Artists: "+numArtists);
        System.out.println("Exhibition Fee: "+exhibitionFee);
    }
}

public class EventPlannerFestivalManagementSystem {
    static Map<String, Festival> festivals=new HashMap<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            String input=sc.nextLine();
            if(input.equals("EXIT")){
                return;
            }
            else{
                processCommands(input);
            }
        }
    }

    public static void processCommands(String input){
        String[] parts=input.split(" ");
        String operation=parts[0];

        switch (operation){
            case "ADD_FESTIVAL":{
                String festivalType=parts[1];
                if(festivalType.equals("MUSIC")){
                    Music music=new Music(parts[2], parts[3], parts[4], parts[5],
                            parts[6], Integer.parseInt(parts[7]));
                    festivals.putIfAbsent(parts[2],music);
                }

                if(festivalType.equals("FOOD")){
                    Food food=new Food(parts[2], parts[3], parts[4], parts[5],
                            Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
                    festivals.putIfAbsent(parts[2], food);
                }

                if(festivalType.equals("ART")){
                    Art art=new Art(parts[2], parts[3], parts[4], parts[5],
                            Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
                    festivals.putIfAbsent(parts[2], art);
                }
                break;
            }

            case "DISPLAY_DETAILS":{
                String name=parts[1];
                Festival f=festivals.get(name);
                f.displayDetails();
                break;
            }
        }
    }
}
