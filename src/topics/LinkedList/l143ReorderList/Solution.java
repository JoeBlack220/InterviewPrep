package topics.LinkedList.l143ReorderList;
import datastructure.ListNode;

// first find the middle Node of the LinkedList
// reverse the last half of the linkedlist
// merge the first half and the reversed second half
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head, res = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        merge(res, reverse(slow));
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;
            if(n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
