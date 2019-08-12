package topics.LinkedList.l148SortList;
import datastructure.ListNode;
public class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode left = head, right = split(head);
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private ListNode split(ListNode head) {
        ListNode fast = head;
        ListNode slow = head, res = head;
        while(fast != null && fast.next != null) {
            res = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        res.next = null;
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(left != null || right != null) {
            if(left == null) {
                res.next = right;
                right = right.next;
            }
            else if(right == null) {
                res.next = left;
                left = left.next;
            }
            else if(right.val < left.val) {
                res.next = right;
                right = right.next;
            }
            else {
                res.next = left;
                left = left.next;
            }
            res = res.next;
        }
        return dummy.next;
    }
}