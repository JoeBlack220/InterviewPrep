package topics.LinkedList.l19RemoveNthNodeFromEndofList;
import java.util.*;
import datastructure.ListNode;
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumb = head;
        List<ListNode> list = new LinkedList<ListNode>();
        while(dumb != null){
            list.add(dumb);
            dumb = dumb.next;
        }
        int index = list.size() - n - 1;
        if(index < 0) return head.next;
        else{
            ListNode cur = list.get(index);
            cur.next = cur.next.next;
        }
        return head;
    }
}
