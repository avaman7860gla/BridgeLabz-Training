import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class Participant{
    private int id;
    private String name;
    private Map<Integer, Boolean> submissions;
    private int score;

    public Participant(int id, String name, Map<Integer, Boolean> submissions){
        this.id=id;
        this.name=name;
        this.submissions=submissions;
        this.score=calculateScore();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Boolean> getSubmissions() {
        return submissions;
    }

    public int getScore() {
        return score;
    }

    public int calculateScore(){
        return (int) submissions.values().stream().filter(v->v).count();
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
class LateSubmissionException extends Exception{
    LateSubmissionException(String mssg){
        super(mssg);
    }
}

class Submission{
    private Participant participant;
    private LocalDateTime submissionTime;

    public Submission(Participant participant, LocalDateTime submissionTime){
        this.participant=participant;
        this.submissionTime=submissionTime;
    }

    public Participant getParticipant() {
        return participant;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void validateSubmission(LocalDateTime deadline) throws LateSubmissionException{
        if(getSubmissionTime().isAfter(deadline)){
            throw new LateSubmissionException("Late submission");
        }
        System.out.println("Submission is done on time");
    }
}

class Leaderboard{
    private List<Participant> participants;

    public Leaderboard(List<Participant> participants){
        this.participants=participants;
    }

    public void displayLeaderboard(){
        sortParticipants();
        System.out.println(participants);
        participants.forEach(p->System.out.println(p.getName()+" - "+p.getScore()));
    }

    public void sortParticipants(){
        participants=participants.stream().sorted(Comparator.comparing(Participant::getScore).reversed())
                .collect(Collectors.toList());
    }
}


public class OnlineHackathonSubmissionEvaluator {
    public static void main(String[] args) {
        Map<Integer, Boolean> results1 = new HashMap<>();
        results1.put(1, true);
        results1.put(2, false);
        results1.put(3, true);

        Map<Integer, Boolean> results2 = new HashMap<>();
        results2.put(1, true);
        results2.put(2, true);
        results2.put(3, true);

        Map<Integer, Boolean> results3 = new HashMap<>();
        results3.put(1, false);
        results3.put(2, false);
        results3.put(3, true);

        Participant p1 = new Participant(101, "Aman", results1);
        Participant p2 = new Participant(102, "Riya", results2);
        Participant p3 = new Participant(103, "Karan", results3);

        LocalDateTime deadline = LocalDateTime.now().minusMinutes(5);
        Submission s1 = new Submission(p1, LocalDateTime.now().minusMinutes(10));
        Submission s2 = new Submission(p2, LocalDateTime.now().minusMinutes(2));
        Submission s3 = new Submission(p3, LocalDateTime.now().minusMinutes(20));

        try {
            s1.validateSubmission(deadline);
            System.out.println(p1.getName() + " submission accepted.");
        }
        catch (LateSubmissionException e) {
            System.out.println(p1.getName() + " submission rejected: " + e.getMessage());
        }

        try {
            s2.validateSubmission(deadline);
            System.out.println(p2.getName() + " submission accepted.");
        }
        catch (LateSubmissionException e) {
            System.out.println(p2.getName() + " submission rejected: " + e.getMessage());
        }

        try {
            s3.validateSubmission(deadline);
            System.out.println(p3.getName() + " submission accepted.");
        }
        catch (LateSubmissionException e) {
            System.out.println(p3.getName() + " submission rejected: " + e.getMessage());
        }

        // Build leaderboard
        List<Participant> participants = Arrays.asList(p1, p2, p3);
        Leaderboard leaderboard = new Leaderboard(participants);

        // Display leaderboard
        leaderboard.displayLeaderboard();
    }
}

