package topics.LinkedList.l2AddTwoNumbers;
import java.util.*;
import datastructure.ListNode;
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int car = 0;
        while(l1 != null || l2 != null || car != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            car += val1 + val2;
            ListNode cur = new ListNode(car % 10);
            car /= 10;
            res.next = cur;
            res = res.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return dummy.next;
    }
}
