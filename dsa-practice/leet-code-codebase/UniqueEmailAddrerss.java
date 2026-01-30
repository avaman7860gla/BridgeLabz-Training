import java.util.HashSet;

public class UniqueEmailAddrerss {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean ignore = false, atEnd = false;
            char[] emailStr = email.toCharArray();
            for(char ch : emailStr) {
                if (!atEnd && ch == '+') {
                    ignore = true;
                }
                else if (ch == '@') {
                    ignore = false;
                    atEnd = true;
                }
                else if (!atEnd && ch == '.') {
                    continue;
                }
                if (!ignore) {
                    sb.append(ch);
                }
            }
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}