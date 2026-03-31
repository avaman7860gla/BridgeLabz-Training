
public class ReorderList {
    public ListNode reorderList(ListNode head) {
        
       if (head == null || head.next == null) {
           return head;
       }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverseList(secondHalf);

        ListNode firstPointer = head;
        ListNode secondPointer = secondHalf;
        while (secondPointer != null) {
            ListNode temp1 = firstPointer.next;
            ListNode temp2 = secondPointer.next;

            firstPointer.next = secondPointer;
            secondPointer.next = temp1;

            firstPointer = temp1;
            secondPointer = temp2;
        }
        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}