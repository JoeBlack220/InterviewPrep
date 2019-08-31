package topics.LinkedList.l92ReverseLinkedListII;
import datastructure.ListNode;
public class Solution {
    // find four node, the number m, m - 1, n, n + 1 node in the list
    // reverse the node from m to n
    // link the reversed list with number m - 1 node and number n + 1 node
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head, second = head, prevFirst = dummy, nextSecond = null;
        while(head != null) {
            i ++;
            if(i == m - 1) prevFirst = head;
            if(i == m) first = head;
            if(i == n) second = head;
            if(i == n + 1) nextSecond = head;
            head = head.next;
        }
        helper(first, second);
        prevFirst.next = second;
        first.next = nextSecond;
        return dummy.next;
    }

    private void helper(ListNode first, ListNode second) {
        ListNode prev = null, cur = first, temp;
        while(prev != second) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
    }
}
