package topics.LinkedList.l25ReverseNodesinkGroup;
import datastructure.ListNode;
// first find that whether the linked list has k nodes
// if so recursively build reverseKGroup from index k + 1, that will be the tail of the current reversed group
// reverse the current k nodes, append the tail to the reversed node, return the new head
// otherwise, just return the head

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while (count < k && curr != null) {
            count++;
            curr = curr.next;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count > 0) {
                count--;
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        return head;
    }
}
// iterative solution
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        for(ListNode n = head; n != null; count++, n = n.next);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for(ListNode prev = dummy; count >= k; count -= k) {
            ListNode start = prev.next;
            ListNode then = start.next;
            for(int i = 1; i < k; ++i) {
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
                then = start.next;
            }
            prev = start;

        }
        return dummy.next;
    }
}