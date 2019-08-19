package topics.LinkedList.l23MergekSortedLists;
import datastructure.ListNode;
import java.util.*;
// priority queue solution nlogn
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode node: lists) {
            if(node != null) pq.offer(node);
        }
        while(!pq.isEmpty()) {
            ListNode next = pq.poll();
            cur.next = next;
            next = next.next;
            if(next != null) pq.offer(next);
            cur = cur.next;
        }
        return dummy.next;
    }
}

// merge sort solution
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int number = lists.length;
        if (number == 1) return lists[0];
        return mergeK(lists, 0, number - 1);
    }

    private ListNode mergeK(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        else if (start == end) return lists[start];
        else if (start + 1 == end) return merge2Lists(lists[start], lists[end]);

        int mid = start + (end - start) / 2;
        ListNode leftR = mergeK(lists, start, mid);
        ListNode rightR = mergeK(lists, mid + 1, end);
        return merge2Lists(leftR, rightR);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummyHead.next;
    }
}