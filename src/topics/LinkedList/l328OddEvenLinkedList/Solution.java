package topics.LinkedList.l328OddEvenLinkedList;
import datastructure.ListNode;
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head;
        ListNode even = head.next;

        ListNode oddPointer = odd;
        ListNode evenPointer = even;
        while(oddPointer != null && evenPointer != null) {
            oddPointer.next = evenPointer.next;
            oddPointer = oddPointer.next;
            evenPointer.next = oddPointer == null ? null : oddPointer.next;
            evenPointer = evenPointer.next;
        }

        oddPointer = odd;
        while(oddPointer.next != null) oddPointer = oddPointer.next;
        oddPointer.next = even;
        return odd;

    }
}
