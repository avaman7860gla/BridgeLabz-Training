import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {

    // method to format date
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class DateFormatDemo {
    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        System.out.println("Default Format: " +DateUtils.formatDate(invoiceDate, "dd-MM-yyyy"));

        System.out.println("Invoice Format: " +DateUtils.formatDate(invoiceDate, "yyyy/MM/dd"));
    }
}
