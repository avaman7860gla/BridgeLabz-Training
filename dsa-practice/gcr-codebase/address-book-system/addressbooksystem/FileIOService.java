import java.io.FileWriter;
import java.io.PrintWriter;

// UC13: text file
public class FileIOService{
    public static void write(AddressBook b,String file){
        try(PrintWriter pw=new PrintWriter(new FileWriter(file))){
            b.getContacts().forEach(c->pw.println(String.join(",",c.getFirstName(),
                            c.getLastName(),c.getAddress(),
                            c.getCity(),c.getState(),
                            c.getZip(),c.getPhoneNo(),
                            c.getEmail())));
            System.out.println("Txt Saved");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}