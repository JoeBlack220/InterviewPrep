package topics.LinkedList.l160IntersectionofTwoLinkedLists;
import datastructure.ListNode;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA, pointer2 = headB;
        while(pointer1 != pointer2) {
            pointer1 = pointer1 == null ? headB : pointer1.next;
            pointer2 = pointer2 == null ? headA : pointer2.next;
        }
        return pointer1;
    }
}
