import java.util.*;

public class Program {
    // Static list
    public static List<CreatorStats> engagementBoard=new ArrayList<>();

    // Method to register creator
    public void registerCreator(CreatorStats record){
        engagementBoard.add(record);
        System.out.println("Creator registered successfully");
    }

    // Method to get top post count
    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold){
        Map<String, Integer> map=new HashMap<>();
        for(CreatorStats stats:records){
            int c=0;
            for(double likes: stats.weeklyLikes){
                if(likes>=likeThreshold){
                    c++;
                }
            }
            if(c>0) {
                map.put(stats.creatorName, c);
            }
        }
        return map;
    }

    // Method to calculate average likes
    public double calculateAverageLikes(){
        if(engagementBoard.isEmpty()){
            return 0;
        }
        double totalLikes=0;
        int totalWeeks=0;
        for(CreatorStats stats:engagementBoard) {
            for(double like:stats.weeklyLikes) {
                totalLikes+=like;
                totalWeeks++;
            }
        }
        return totalLikes/totalWeeks;
    }

    public static void main(String[] args) {

        Program p=new Program();

        Scanner sc=new Scanner(System.in);
        
        while(true) {
            System.out.println("1.Register Creator\n"+"2.Show Top Posts\n"+"3.Calculate Average Likes\n"+"4.Exit");

            System.out.println("Enter your choice:");
            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Creator Name:");
                    String name = sc.next();

                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    double[] weeklyLikes = new double[4];
                    for (int i = 0; i < 4; i++) {
                        weeklyLikes[i] = sc.nextDouble();
                    }

                    CreatorStats record = new CreatorStats(name, weeklyLikes);
                    p.registerCreator(record);
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double likeThreshold = sc.nextDouble();

                    Map<String, Integer> map = p.getTopPostCounts(engagementBoard, likeThreshold);
                    if (map.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    }
                    else {
                        for (Map.Entry<String, Integer> e : map.entrySet()) {
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Overall average weekly likes: " + p.calculateAverageLikes());
                    break;
                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    return;
            }
        }

    }

}
