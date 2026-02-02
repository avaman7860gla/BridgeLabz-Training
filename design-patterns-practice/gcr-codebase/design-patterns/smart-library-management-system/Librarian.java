public class Librarian implements User {
    private String name;

    // Constructor
    public Librarian(String name){
        this.name=name;
    }

    // Override methods
    @Override
    public void showRole(){
        System.out.println(name+" is a librarian");
    }

    @Override
    public void update(String message){
        System.out.println(name+" receive notification: "+message);
    }
}
