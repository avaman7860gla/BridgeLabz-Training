public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }

        for(int i=0;i<list.size()-1;i+=2){
            int temp1=list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1,temp1);
        }

        temp=head;
        int i=0;
        while(temp!=null){
            if(list.size()>i){
                temp.val=list.get(i);
                i++;
            }
            temp=temp.next;
        }

        return head;
    }
}