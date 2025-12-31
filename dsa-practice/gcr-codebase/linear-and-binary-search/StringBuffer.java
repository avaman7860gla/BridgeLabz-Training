public class StringBuffer {
    public static String concatStrings(String[] arr) {

        // stringbuffer
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            // add element to sb
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] arr = {"Hello", " ", "World", "!"};
        System.out.println("Concatenated: " + concatStrings(arr));
    }
}
