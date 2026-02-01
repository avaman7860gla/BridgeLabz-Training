public class UserFactory {
    // Method to create user 
    public static User createUser(String type, String name){
        if(type==null){
            return null;
        }

        // Call user type accordingly
        switch(type.toLowerCase()){
            case "student":
                return new Student(name);
            case "faculty":
                return new Faculty(name);
            case "librarian":
                return new Librarian(name);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }    
}
