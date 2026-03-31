import java.util.ArrayList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }

        Collections.reverse(list);

        temp=head;
        int i=0;
        while(temp!=null){
            if(list.size()>i){
                temp.val=list.get(i++);
            }
            temp=temp.next;
        }
        return head;
    }
}