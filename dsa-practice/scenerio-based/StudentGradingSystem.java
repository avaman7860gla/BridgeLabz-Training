import java.util.Scanner;

public class StudentGradingSystem {

    static Scanner sc = new Scanner(System.in);

    // method to calculate total and average for each student
    static void calculateStudentAverage(String[] students, int[] ids, int[][] grades) {
        for (int i = 0; i < students.length; i++) {
            int total = 0;
            int count = 0;

            for (int j = 0; j < grades[i].length; j++) {
                if (grades[i][j] != -1) {
                    total += grades[i][j];
                    count++;
                }
            }

            if (count == 0) {
                System.out.println(students[i] + " ID: " + ids[i] + " has incomplete records.");
            } 
            else {
                double avg = (double) total / count;
                System.out.println(students[i] + " ID: " + ids[i] + " Total: " + total + " Average: " + avg);
            }
        }
    }

    // method to find highest grade in each subject
    static void highestGradePerSubject(int[][] grades, int subjects) {
        for (int j = 0; j < subjects; j++) {
            int max = -1;
            for (int i = 0; i < grades.length; i++) {
                if (grades[i][j] > max) {
                    max = grades[i][j];
                }
            }
            System.out.println("Highest grade in Subject " + (j + 1) + " : " + max);
        }
    }

    // Method to calculate overall class average
    static void calculateClassAverage(int[][] grades) {
        int total = 0;
        int count = 0;
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade != -1) {
                    total += grade;
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println("Invalid grades");
        } 
        
        else {
            System.out.println("Overall Class Average: " + (double) total / count);
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter number of students: ");
        int n = sc.nextInt();

        System.out.println("Enter number of subjects: ");
        int subjects = sc.nextInt();

        sc.nextLine(); 

        String[] students = new String[n];
        int[] ids = new int[n];
        int[][] grades = new int[n][subjects];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Student Name: ");
            students[i] = sc.nextLine();

            System.out.println("Enter Student ID: ");
            ids[i] = sc.nextInt();

            for (int j = 0; j < subjects; j++) {
                try {
                    System.out.println("Enter grade for Subject " + (j + 1) + ": ");
                    int grade = sc.nextInt();

                    if (grade < 0 || grade > 100) {
                        throw new IllegalArgumentException("Grade must be between 0 and 100");
                    }

                    grades[i][j] = grade;

                } catch (Exception e) {
                    System.out.println("Invalid input");
                    grades[i][j] = -1;
                    sc.nextLine();
                }
            }
        }

        System.out.println("Student Results:");
        calculateStudentAverage(students, ids, grades);

        System.out.println("Subject Toppers:");
        highestGradePerSubject(grades, subjects);

        System.out.println("Class Performance:");
        calculateClassAverage(grades);
    }
}
