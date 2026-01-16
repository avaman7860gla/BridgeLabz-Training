import java.util.ArrayList;
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String first="qwertyuiop";
        String second="asdfghjkl";
        String third="zxcvbnm";

        ArrayList<String> list=new ArrayList<>();
        for(String word:words){
            if(check(word,first) || check(word, second) || check(word, third)){
                list.add(word);
            }
        }
        String[] ans=new String[list.size()];
        int i=0;
        for(String str:list){
            ans[i++]=str;
        }
        return ans;
    }
    public boolean check(String s, String row){
        for(char ch:s.toCharArray()){
            if(row.indexOf(Character.toLowerCase(ch))==-1){
                return false;
            }
        }
        return true;
    }
}