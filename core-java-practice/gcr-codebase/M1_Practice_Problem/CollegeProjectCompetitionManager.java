package M1_Practice_Problem;

import java.util.*;

class ProjectTeam {
    String teamId;
    String section;
    String domain;
    String projectName;
    int projectScore;

    public ProjectTeam(String teamId, String section, String domain, String projectName, int projectScore) {
        this.teamId=teamId;
        this.section=section;
        this.domain=domain;
        this.projectName=projectName;
        this.projectScore=projectScore;
    }
}

class CompetitionManager {
    List<ProjectTeam> teamList = new ArrayList<>();

    public int registerTeam(String teamId, String section, String domain, String projectName, int projectScore) {
        for(ProjectTeam team:teamList){
            if(team.teamId.equals(teamId)){
                return 0;
            }
        }
        ProjectTeam team=new ProjectTeam(teamId, section, domain, projectName, projectScore);
        teamList.add(team);

        return 0;
    }

    public int reviseScore(String teamId, int projectScore) {
        for(ProjectTeam team:teamList){
            if(team.teamId.equals(teamId)){
                team.projectScore=projectScore;
                System.out.println("REVISED "+teamId+" "+projectScore);
                return 0;
            }
        }
        System.out.println("team is not available");
        return 0;
    }

    public List<ProjectTeam> filterByDomain(String domain) {
        List<ProjectTeam> result = new ArrayList<>();

        for(ProjectTeam team:teamList){
            if(team.domain.equals(domain)){
                result.add(team);
            }
        }
        return result;
    }

    public List<ProjectTeam> qualifyTeams(int cutoff) {
        List<ProjectTeam> result = new ArrayList<>();

        for(ProjectTeam team:teamList){
            if(team.projectScore>=cutoff){
                result.add(team);
            }
        }
        return result;
    }
}

public class CollegeProjectCompetitionManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CompetitionManager manager = new CompetitionManager();

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String command = parts[0];
            switch (command) {
                case "REGISTER":{
                    manager.registerTeam(parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]));
                    break;
                }

                case "REVISE":{
                    manager.reviseScore(parts[1], Integer.parseInt(parts[2]));
                    break;
                }

                case "FILTERDOMAIN":{
                    List<ProjectTeam> list=manager.filterByDomain(parts[1]);
                    if(list.isEmpty()){
                        System.out.println("Team is not available for the domain: "+parts[1]);
                    }
                    else{
                        for(ProjectTeam team:list){
                            System.out.println(team.teamId+" "+team.section+" "+team.domain+" "+team.projectName+
                                    " "+team.projectScore);
                        }
                    }
                    break;
                }

                case "QUALIFY":{
                    List<ProjectTeam> list=manager.qualifyTeams(Integer.parseInt(parts[1]));
                    if(list.isEmpty()){
                        System.out.println("No team qualified");
                    }
                    else{
                        for(ProjectTeam team:list){
                            System.out.println(team.teamId+" "+team.section+" "+team.domain+" "+team.projectName+
                                    " "+team.projectScore);
                        }
                    }
                    break;
                }
            }
        }
    }
}
