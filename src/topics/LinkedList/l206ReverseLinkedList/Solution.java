package topics.LinkedList.l206ReverseLinkedList;
import datastructure.ListNode;
public class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }

    public ListNode helper(ListNode cur, ListNode prev) {
        if(cur == null) return prev;
        ListNode next = cur.next;
        cur.next = prev;
        return helper(next, cur);
    }
}
// iterative solution
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
