package M1_Practice_Problem;

import java.util.*;

class URLValidator {
    Set<String> urlSet = new HashSet<>();

    public String validateURL(String url) {
        if(!url.contains("://") || !url.contains(".")){
            return "INVALID URL: format is invalid";
        }

        if(!(url.startsWith("http://") || url.startsWith("https://"))){
            return "INVALID URL: protocol is invalid";
        }

        String remaining=url.substring(url.indexOf("://")+3);

        int dotIndex=remaining.lastIndexOf(".");
        if(dotIndex==-1){
            return "INVALID URL: format is invalid";
        }

        String website=remaining.substring(0, dotIndex);
        String domain=remaining.substring(dotIndex);

        if(!website.matches("[a-z]+") || website.length()>10){
            return "INVALID URL: website name is invalid";
        }

        if(!(domain.equals(".com") || domain.equals(".co") || domain.equals(".in") ||
                domain.equals(".org") || domain.equals(".gov"))){
            return "INVALID URL: domain is invalid";
        }

        if(urlSet.contains(url)){
            return "DUPLICATE URL FOUND";
        }

        urlSet.add(url);
        return "VALID URL";
    }
}

public class URLValidationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        URLValidator validator = new URLValidator();
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String url = sc.nextLine();
            System.out.println(validator.validateURL(url));
        }
    }
}
