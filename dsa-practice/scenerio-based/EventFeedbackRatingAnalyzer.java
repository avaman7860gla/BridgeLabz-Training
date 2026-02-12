import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Custom exception
class InvalidRatingException extends Exception{
    InvalidRatingException(String mssg){
        super(mssg);
    }
}

class FeedbackAnalyzer{
    private Map<String, List<Integer>> feedbacks=new HashMap<>();

    // Method to add feedbacks
    public void addFeedback(String eventId, int rating) throws InvalidRatingException{
        if(rating<1 || rating>5) {
            throw new InvalidRatingException("Invalid rating (not in 1-5)");
        }
        if(!feedbacks.containsKey(eventId)){
            feedbacks.put(eventId, new ArrayList<>());
        }
        feedbacks.get(eventId).add(rating);
    }

    // Method to calculate average rating by event id
    public double calculateAverage(String eventId){
        List<Integer> rating=feedbacks.get(eventId);
        double total=0;
        for(int r:rating){
            total+=r;
        }
        return total/rating.size();
    }

    // Method to get top rated events
    public List<String> getTopRatedEvents() {
        double maxAvg=0;
        List<String> topEvents=new ArrayList<>();
        for(String eventId:feedbacks.keySet()){
            double avg=calculateAverage(eventId);
            if(avg>maxAvg){
                maxAvg=avg;
            }
        }
        for(String eventId:feedbacks.keySet()){
            double avg=calculateAverage(eventId);
            if (avg==maxAvg) {
                topEvents.add(eventId);
            }
        }
        return topEvents;
    }

    // Method to get all feedbacks
    public Map<String, List<Integer>> getFeedbacksMap(){
        return feedbacks;
    }
}

public class EventFeedbackRatingAnalyzer {
    public static void main(String[] args) {

        FeedbackAnalyzer util=new FeedbackAnalyzer();

        try{
            util.addFeedback("101", 4);
            util.addFeedback("101", 5);

            util.addFeedback("102", 3);

            util.addFeedback("103", 6);
        }
        catch (InvalidRatingException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAverage of event 101: "+util.calculateAverage("101"));

        System.out.println("\nTop rated events: "+util.getTopRatedEvents());

        System.out.println("\nAll feedbacks (event id | list of ratings): ");
        Map<String, List<Integer>> map=util.getFeedbacksMap();
        for(Map.Entry<String, List<Integer>> e:map.entrySet()){
            System.out.println(e.getKey()+" | "+e.getValue());
        }
    }
}
