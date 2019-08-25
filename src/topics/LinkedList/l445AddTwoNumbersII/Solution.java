package topics.LinkedList.l445AddTwoNumbersII;
import datastructure.ListNode;
import java.util.*;
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode tail1 = helper(l1, map);
        ListNode tail2 = helper(l2, map);
        return add(tail1, tail2, 0, map, null);

    }

    private ListNode add(ListNode l1, ListNode l2, int car, Map<ListNode, ListNode> map, ListNode next) {
        int val1 = 0, val2 = 0;
        if(l1 != null) {
            val1 = l1.val;
            l1 = map.get(l1);
        }
        if(l2 != null) {
            val2 = l2.val;
            l2 = map.get(l2);
        }
        int total = val1 + val2 + car;
        ListNode res = new ListNode(total % 10);
        res.next = next;
        car = total / 10;
        if(l1 == null && l2 == null && car == 0) return res;
        else return add(l1, l2, car, map, res);
    }

    private ListNode helper(ListNode head, Map<ListNode, ListNode> map) {
        ListNode prev = null;
        while(head != null) {
            map.put(head, prev);
            prev = head;
            head = head.next;
        }
        return prev;
    }
}
