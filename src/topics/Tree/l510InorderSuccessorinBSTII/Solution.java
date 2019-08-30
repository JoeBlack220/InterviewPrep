package topics.Tree.l510InorderSuccessorinBSTII;

public class Solution {
    // if x.right != null, then the successor must be the leftmost node of x.right
    // if x.right == null, the the successor must be the first ancestor node that
    // has the current branch as it's left child
    public Node inorderSuccessor(Node x) {
        if (x.right == null) {
            Node cur = x;
            while (cur.parent != null && cur.parent.right == cur) {
                cur = cur.parent;
            }

            return cur.parent;
        }
        Node cur = x.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}
// using BST's attributes
class Solution2 {
    public Node inorderSuccessor(Node x) {
        if (x.right == null) {
            Node result = x.parent;
            while (result != null && result.val < x.val) {
                result = result.parent;
            }
            return result;
        } else {
            Node result = x.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}