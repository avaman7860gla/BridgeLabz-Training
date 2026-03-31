import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        // Take input from the user
        Scanner sc = new Scanner(System.in);

        int age1 = sc.nextInt();
        int height1 = sc.nextInt();
        int age2 = sc.nextInt();
        int height2 = sc.nextInt();
        int age3 = sc.nextInt();
        int height3 = sc.nextInt();

        
        String youngest="";
        String tallest="";


        // Find tallest
        if (height1 >= height2 && height1 >= height3) {
            tallest = "Amar";
        } 
        else if (height2 >= height3) {
            tallest = "Akbar";
        } 
        else {
            tallest = "Anthony";
        }

        // Find youngest
        if (age1 <= age2 && age1 <= age3) {
            youngest = "Amar";
        } 
        else if (age2 <= age3) {
            youngest = "Akbar";
        } 
        else {
            youngest = "Anthony";
        }

        
        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);
    }
}
