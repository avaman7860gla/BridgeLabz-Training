import java.util.PriorityQueue;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->score[b]-score[a]);
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        int i=1;
        while(!pq.isEmpty()){
            int idx = pq.poll();
            if(i>3){
                ans[idx] = Integer.toString(i);
            }
            else if(i==1){
                ans[idx] = "Gold Medal";
            }
            else if(i==2){
                ans[idx] = "Silver Medal";
            }else if(i==3){
                ans[idx] = "Bronze Medal";
            }
            i++;
        }
        return ans;
    }
}