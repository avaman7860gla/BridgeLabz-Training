import java.util.ArrayList;
public class MiddleOfLinkedLists {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp);
            temp=temp.next;
        }

        int size=list.size();
        int midIdx=size/2;

        
        return list.get(midIdx);
    }
}