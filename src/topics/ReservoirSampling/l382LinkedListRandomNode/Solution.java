package topics.ReservoirSampling.l382LinkedListRandomNode;
import java.util.*;
import datastructure.ListNode;
public class Solution {

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head = null;
    Random r = new Random();

    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int result = this.head.val;
        ListNode node = this.head.next;
        int k =1;
        int i = 1;
        while(node != null){
            double x = r.nextDouble();
            double y = k / (k+i *1.0);
            if(x <= y){
                result = node.val;
            }

            i++;
            node = node.next;
        }

        return result;
    }
}
