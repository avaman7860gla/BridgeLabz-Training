class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String ans="";
        String l=strs[0];
        String r=strs[strs.length-1];
        int n=Math.min(l.length(),r.length());
        for(int i=0;i<n;i++){
            if(l.charAt(i)!=r.charAt(i)){
                return ans;
            }
            ans=ans+l.charAt(i);
        }
        return ans;
    }
}