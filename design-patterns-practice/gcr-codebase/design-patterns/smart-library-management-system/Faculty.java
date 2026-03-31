public class Faculty implements User {
    private String name;

    // Constructor
    public Faculty(String name){
        this.name=name;
    }

    // Override methods
    @Override
    public void showRole(){
        System.out.println(name+" is a faculty");
    }

    @Override
    public void update(String message){
        System.out.println(name+" receive notification: "+message);
    }
}
