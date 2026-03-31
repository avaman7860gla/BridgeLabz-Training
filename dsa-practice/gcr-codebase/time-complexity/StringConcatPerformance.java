
public class StringConcatPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int n : sizes) {
            
            // for string
            long start = System.nanoTime();  // start time
            String s = "";
            for (int i = 0; i < n; i++) 
                s += "a";
            System.out.print(s.hashCode()); // use s to avoid unused warning
            long end = System.nanoTime();    // end time
            System.out.printf("String (N=%d): %.4f ms\n", n, (end - start) / 1e6);

            // for string builder
            start = System.nanoTime();    // start time
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) 
                sb.append('a');
            if (sb.length() == -1) 
                System.out.print("");
            end = System.nanoTime();     // end time
            System.out.printf("StringBuilder (N=%d): %.4f ms\n", n, (end - start) / 1e6);

            // for string buffer
            start = System.nanoTime();      // start time
            StringBuffer sbuf = new StringBuffer();
            for (int i = 0; i < n; i++) 
                sbuf.append('a');
            System.out.print(sbuf.hashCode()); // use sbuf to avoid unused warning
            end = System.nanoTime();      // end time
            System.out.printf("StringBuffer (N=%d): %.4f ms\n", n, (end - start) / 1e6);

        }
    }
}
