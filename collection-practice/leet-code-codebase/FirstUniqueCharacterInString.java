import java.util.HashMap;
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        String a  = "";
		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			if (hm.containsKey(s1)) {
				hm.put(s1, hm.get(s1)+1);
			}
			else{
				hm.put(s1, 1);
			}
		}
		for (Map.Entry e : hm.entrySet()) {
			if ((Integer) e.getValue()==1) {
                a+=(Character)e.getKey();
            }
		}
        if (a.length()==0) {
            return -1;
        }
   
        int [] arr = new int[a.length()];
        
        for(int i=0;i<a.length();i++){
            for(int j=0;j<s.length();j++){
                if (a.charAt(i)==s.charAt(j)){
                    arr[i]=j;
                    break;
                } 
            }
        }
        Arrays.sort(arr);
        return arr[0];
    }
}
