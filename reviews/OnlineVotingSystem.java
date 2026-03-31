import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class DuplicateVoteException extends Exception {
    DuplicateVoteException(String message) {
        super(message);
    }
}

abstract class ElectionService {
    abstract void register(int id, String name);
}

class Candidate extends ElectionService {
    void register(int candId, String candName) {
        OnlineVotingSystem.candidates.put(candId, candName);
        OnlineVotingSystem.voteCount.put(candId, 0);
    }

    void displayCandidates() {
        System.out.println("candidate list");
        for (Map.Entry<Integer, String> e:OnlineVotingSystem.candidates.entrySet()) {
            System.out.println("ID: " + e.getKey() + " Name: " + e.getValue());
        }
    }
}

class Voter extends ElectionService {
    void register(int voterId, String voterName) {
        OnlineVotingSystem.voters.put(voterId, voterName);
    }

    void displayVoters() {
        System.out.println("Voter list");
        for (Map.Entry<Integer, String> e:OnlineVotingSystem.voters.entrySet()) {
            System.out.println("ID: " + e.getKey() + " | Name: " + e.getValue());
        }
    }

    void vote(int voterId, int candidateId) throws DuplicateVoteException {
        if (OnlineVotingSystem.voteInfo.containsKey(voterId)) {
            throw new DuplicateVoteException("Voter " + voterId + " has already voted!");
        }

        if (!OnlineVotingSystem.candidates.containsKey(candidateId)) {
            System.out.println("Invalid Candidate ID");
            return;
        }

        OnlineVotingSystem.voteInfo.put(voterId, candidateId);
        OnlineVotingSystem.voteCount.put(candidateId,OnlineVotingSystem.voteCount.get(candidateId) + 1);

        System.out.println("vote cast successfully");
    }
}

public class OnlineVotingSystem {
    static HashMap<Integer, String> candidates=new HashMap<>();
    static HashMap<Integer, String> voters=new HashMap<>();
    static HashMap<Integer, Integer> voteInfo=new HashMap<>();
    static HashMap<Integer, Integer> voteCount=new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Candidate candidate = new Candidate();
        Voter voter = new Voter();

        System.out.println("welcome to online voting system");

        System.out.print("enter number of candidates: ");
        int c = sc.nextInt();

        for (int i = 1; i <= c; i++) {
            System.out.print("enter candidate ID: ");
            int id = sc.nextInt();

            System.out.print("enter candidate Name: ");
            String name = sc.next();

            candidate.register(id, name);
        }
        candidate.displayCandidates();

        System.out.print("enter number of voters: ");
        int v = sc.nextInt();

        for (int i = 1; i <= v; i++) {
            System.out.print("enter voter ID: ");
            int id = sc.nextInt();

            System.out.print("enter voter Name: ");
            String name = sc.next();

            voter.register(id, name);
        }
        voter.displayVoters();

        System.out.println("voting starts");
        for (int i = 0; i < v; i++) {
            try {
                System.out.print("enter voter ID: ");
                int voterId = sc.nextInt();

                System.out.print("enter candidate ID: ");
                int candidateId = sc.nextInt();

                voter.vote(voterId, candidateId);

            } 
            catch (DuplicateVoteException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("voting results");
        int maxVotes = 0;
        String winner = "";

        for (Map.Entry<Integer, Integer> e : voteCount.entrySet()) {
            System.out.println("candidate: " + candidates.get(e.getKey()) +" votes: " + e.getValue());
            if (e.getValue() > maxVotes) {
                maxVotes = e.getValue();
                winner = candidates.get(e.getKey());
            }
        }
        System.out.println("winner: " + winner + " with " + maxVotes + " votes");
    }
}
