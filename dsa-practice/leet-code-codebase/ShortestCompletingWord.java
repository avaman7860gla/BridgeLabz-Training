
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
    	int[] numOfChars = new int[26];
    	
    	String minStr = "";
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < licensePlate.length(); i++){
    		char c = licensePlate.charAt(i);
    		if (c >= 'a' && c <= 'z'){
    			numOfChars[c - 'a']++;
    		}
    	}
    	
    	for (int i = 0; i < words.length; i++){
            int[] numOfCharsTemp = numOfChars.clone();
    		for (int j = 0; j < words[i].length(); j++){
    			char c = words[i].charAt(j);
    			numOfCharsTemp[c - 'a']--;
    		}
    		
    		boolean contains = true;
    		
    		for (int j = 0; j < numOfCharsTemp.length; j++){
    			if (numOfCharsTemp[j] > 0){
    				contains = false;
    				break;
    			}
    		}
    		
    		if (contains && words[i].length() < min){
    			min = words[i].length();
    			minStr = words[i];
    		}
    	}       

        return minStr;
        
    }
}
