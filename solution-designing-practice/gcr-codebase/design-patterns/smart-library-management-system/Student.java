public class Student implements User {
    private String name;

    // Constructor
    public Student(String name){
        this.name=name;
    }

    // Override methods
    @Override
    public void showRole(){
        System.out.println(name+" is a student");
    }

    @Override
    public void update(String message){
        System.out.println(name+" receive notification: "+message);
    }
}
