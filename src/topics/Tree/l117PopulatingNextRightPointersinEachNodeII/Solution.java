package topics.Tree.l117PopulatingNextRightPointersinEachNodeII;
import datastructure.TreeNodeWithNext.Node;
public class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node dummy = new Node(0);        // the head of the upper level
        Node prev = dummy;
        Node cur = root;                 // the head of the lower level
        while(cur != null) {
            Node temp = cur;
            while(temp != null) {
                System.out.println(prev.val);
                if(temp.left != null) {
                    prev.next = temp.left;
                    prev = prev.next;
                }
                if(temp.right != null) {
                    prev.next = temp.right;
                    prev = prev.next;
                }
                temp = temp.next;
            }
            // after having traversed the whole level, move the pointer to the next level
            cur = dummy.next;
            dummy.next = null;
            prev = dummy;
        }
        return root;
    }
}
