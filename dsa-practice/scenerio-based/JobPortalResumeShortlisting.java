import java.util.*;

class Resume{
    private String candidateName;
    private Set<String> skills;

    // Constructor
    public Resume(String candidateName, Set<String> skills){
        this.candidateName=candidateName;
        this.skills=skills;
    }

    // Getters
    public String getCandidateName() {
        return candidateName;
    }

    public Set<String> getSkills() {
        return skills;
    }
}

// Custom exception
class InvalidResumeException extends Exception{
    InvalidResumeException(String mssg){
        super(mssg);
    }
}

class ResumeComparator implements Comparator<Resume> {
    // Override compare maethod
    @Override
    public int compare(Resume r1, Resume r2) {
        return Integer.compare(r1.getSkills().size(),r2.getSkills().size());
    }
}

class JobPortal{
    List<Resume> resumes=new ArrayList<>();
    Set<String> requiredSkills=new HashSet<>(Arrays.asList("Java", "Spring"));

    // Method to add resume
    public void addResume(Resume resume) throws InvalidResumeException{
        if(resume.getCandidateName().isEmpty() || resume.getSkills().isEmpty()){
            throw new InvalidResumeException("Invalid Resume");
        }
        resumes.add(resume);
    }

    // Method to shortlist resumes
    public List<Resume> shortlistResumes(){
        List<Resume> list=new ArrayList<>();
        for(Resume r:resumes){
            Set<String> skills=r.getSkills();
            for(String skill:skills){
                if(requiredSkills.contains(skill)){
                    list.add(r);
                    break;
                }
            }
        }
        return list;
    }

    // Method to rank resume
    public int rankResume(Resume resume){
        return (int) resume.getSkills().stream() .filter(requiredSkills::contains) .count();
    }

    // Method to get all resumes
    public List<Resume> getResumes(){
        return resumes;
    }
}

public class JobPortalResumeShortlisting {
    public static void main(String[] args) throws InvalidResumeException {
        try{
            JobPortal portal=new JobPortal();

            Resume r1=new Resume("Aman", new HashSet<>(Arrays.asList("Java", "Spring", "C++")));
            Resume r2=new Resume("Rahul", new HashSet<>(Arrays.asList("Java", "Python", "C#")));
            Resume r3=new Resume("Amit", new HashSet<>(Arrays.asList("SQL", "Python", "C#")));

            portal.addResume(r1);
            portal.addResume(r2);
            portal.addResume(r3);

            System.out.println("Shortlisted resume: ");
            List<Resume> resumes=portal.shortlistResumes();
            for(Resume r:resumes){
                System.out.println(r.getCandidateName()+" | "+r.getSkills());
            }

            System.out.println("\nRankings of resume: ");
            System.out.println(r1.getCandidateName()+" | Rank: "+portal.rankResume(r1));
            System.out.println(r2.getCandidateName()+" | Rank: "+portal.rankResume(r2));
            System.out.println(r3.getCandidateName()+" | Rank: "+portal.rankResume(r3));

            System.out.println("\nAll resumes:");
            List<Resume> allResumes=portal.getResumes();
            for(Resume r:allResumes){
                System.out.println(r.getCandidateName()+" | "+r.getSkills());
            }
        }
        catch (InvalidResumeException e){
            System.out.println(e.getMessage());
        }
    }

}
