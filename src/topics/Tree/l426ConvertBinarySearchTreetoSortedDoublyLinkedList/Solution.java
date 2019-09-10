package topics.Tree.l426ConvertBinarySearchTreetoSortedDoublyLinkedList;
import java.util.*;
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}
    public Node(int i) {val = i;}
    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class Solution {
    public Node treeToDoublyList(Node root) {
        Node dummy = new Node(0);
        if(root == null) return null;
        Node prev = dummy;

        Deque<Node> stack = new LinkedList<>();
        Node cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            prev.right = cur;
            cur.left = prev;
            prev = cur;
            cur = cur.right;
        }
        Node res = dummy.right;
        res.left = prev;
        prev.right = res;
        return res;
    }
}