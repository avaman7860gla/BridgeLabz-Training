import java.io.Serializable;

// Marker interface used
class UserData implements Serializable {
    private int userId;
    private String name;

    // constructor
    public UserData(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void display() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
    }
}

public class BackupDemo {
    public static void main(String[] args) {

        UserData user = new UserData(101, "Aman");

        System.out.println("User data object is marked serializable");
        System.out.println("Ready for backup processing");
        user.display();
    }
}
