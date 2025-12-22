public class DeleteColumnToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int r = strs.length;
        int cl = strs[0].length();
        int c = 0;

        for (int i = 0; i < cl; i++) {
            for (int j = 1; j < r; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    c++;
                    break; 
                }
            }
        }
        return c;
    }
}

