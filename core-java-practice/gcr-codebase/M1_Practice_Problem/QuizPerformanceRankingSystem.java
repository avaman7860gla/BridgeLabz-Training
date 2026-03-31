package M1_Practice_Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    String studentName;
    String department;
    int quiz1, quiz2, quiz3;

    Student(String studentName, String department, int quiz1, int quiz2, int quiz3){
        this.studentName=studentName;
        this.department=department;
        this.quiz1=quiz1;
        this.quiz2=quiz2;
        this.quiz3=quiz3;
    }
}

public class QuizPerformanceRankingSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        while(n-->0){
            String input=sc.nextLine();
            processCommand(input);
        }
    }

    static List<Student> records=new ArrayList<>();

    public static void processCommand(String input){
        String []parts=input.split(" ");
        String command=parts[0];

        switch (command){
            case "Record":{
                String studentName=parts[1];
                String department=parts[2];
                int quiz1=Integer.parseInt(parts[3]);
                int quiz2=Integer.parseInt(parts[4]);
                int quiz3=Integer.parseInt(parts[5]);

                Student s=new Student(studentName, department, quiz1, quiz2, quiz3);
                records.add(s);
                System.out.println("Record Added: "+studentName);
                break;
            }

            case "Top":{
                String param=parts[1];
                switch(param){
                    case "Q1":{
                        int max=0;
                        for(Student s:records){
                            max=Math.max(max, s.quiz1);
                        }
                        for(Student s:records){
                            if(s.quiz1==max){
                                System.out.println(s.studentName+" "+max);
                            }
                        }
                        break;
                    }
                    case "Q2":{
                        int max=0;
                        for(Student s:records){
                            max=Math.max(max, s.quiz2);
                        }
                        for(Student s:records){
                            if(s.quiz2==max){
                                System.out.println(s.studentName+" "+max);
                            }
                        }
                        break;
                    }
                    case "Q3":{
                        int max=0;
                        for(Student s:records){
                            max=Math.max(max, s.quiz3);
                        }
                        for(Student s:records){
                            if(s.quiz3==max){
                                System.out.println(s.studentName+" "+max);
                            }
                        }
                        break;
                    }
                    default:{
                        int max=0;
                        for(Student s:records){
                            if(s.department.equals(param)){
                                int total=s.quiz1+s.quiz2+s.quiz3;
                                max=Math.max(max, total);
                            }
                        }

                        for(Student s:records){
                            if(s.department.equals(param)){
                                int total=s.quiz1+s.quiz2+s.quiz3;
                                if(total==max){
                                    System.out.println(s.studentName+" "+total);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
