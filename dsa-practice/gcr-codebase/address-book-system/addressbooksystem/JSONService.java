import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

// UC15: Json file
public class JSONService{
    public static void write(AddressBook b,String file){
        try(PrintWriter pw=new PrintWriter(new FileWriter(file))){
            pw.println("[");
            List<Contact> list=b.getContacts();
            for(int i=0;i<list.size();i++){
                Contact c=list.get(i);
                pw.print("{\"firstName\":\""+c.getFirstName()+"\",\"city\":\""+c.getCity()+"\"}");
                if(i!=list.size()-1) {
                    pw.println(",");
                }
                    
            }
            pw.println("\n]");
            System.out.println("JSON Saved");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}