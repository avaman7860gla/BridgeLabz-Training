import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {

    public static void main(String[] args) {

        String filePath = "users.csv";
        String line;

        // regex patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            System.out.println("Invalid Records:");

            // read each line
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];

                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phone).matches();

                // if fails print error
                if (!validEmail || !validPhone) {
                    System.out.println("Row: " + line);

                    if (!validEmail)
                        System.out.println("Invalid Email Format");

                    if (!validPhone)
                        System.out.println("Invalid Phone Number");

                    System.out.println();
                }
            }

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
