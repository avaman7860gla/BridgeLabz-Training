import java.util.*;

class DuplicateAttendanceException extends Exception{
    DuplicateAttendanceException(String mssg){
        super(mssg);
    }
}

class AttendanceTracker{
    private Map<String, Set<String>> attendanceMap=new HashMap<>();

    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException{
        Set<String> students=attendanceMap.getOrDefault(sessionId, new HashSet<>());
        if(students.contains(studentId)){
            throw new DuplicateAttendanceException(studentId+" already marked");
        }
        students.add(studentId);
        attendanceMap.put(sessionId, students);
        System.out.println("Attendance marked for student: "+studentId);
    }

    public void removeAttendance(String sessionId, String studentId){
        if(attendanceMap.containsKey(sessionId)){
            Set<String> students=attendanceMap.get(sessionId);
            if(students.remove(studentId)){
                System.out.println("Attendance removed for student: "+studentId+" from session :"+sessionId);
            }
            else{
                System.out.println("Student "+studentId+" not found in session "+sessionId);
            }
        }
        else{
            System.out.println("Session "+sessionId+" not found");
        }
    }

    public void displayAttendance(String sessionId){
        if(attendanceMap.containsKey(sessionId)){
            Set<String> students=attendanceMap.get(sessionId);
            System.out.println("Attendance for session: "+sessionId+" : "+students);
        }
        else{
            System.out.println("No attendance recorded for session "+sessionId);
        }
    }

    public void displayAllAttendance(){
        if(attendanceMap.isEmpty()){
            System.out.println("No attendance recorded");
        }
        else{
            for(Map.Entry<String, Set<String>> e:attendanceMap.entrySet()){
                System.out.println("Session "+e.getKey()+" - "+e.getValue());
            }
        }
    }
}

public class OnlineAttendanceTracker {
    public static void main(String[] args) {

        AttendanceTracker tracker=new AttendanceTracker();

        try{
            tracker.markAttendance("s1","st1");
            tracker.markAttendance("s1","st2");
            tracker.markAttendance("s2","st3");

            tracker.markAttendance("s1", "st1");
        }
        catch (DuplicateAttendanceException e){
            System.out.println("Error: "+e.getMessage());
        }

        tracker.removeAttendance("s1", "st1");

        tracker.displayAttendance("s1");
        tracker.displayAttendance("s2");

        tracker.displayAllAttendance();

    }
}
