package topics.Tree.l431EncodeNaryTreetoBinaryTree;
import java.util.*;
public class Codec {
    // next level -> left child
    // same level -> right child
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        TreeNode res =  encodeHelper(root, null, 0);
        return res;
    }
    // private void printTree(TreeNode root, int level) {
    //     if(root == null) return;
    //     System.out.println("level" + level + "val" + root.val);
    //     printTree(root.left, level + 1);
    //     printTree(root.right, level + 1);
    // }
    private TreeNode encodeHelper(Node root, List<Node> brothers, int index) {
        if(root == null) return null;
        TreeNode res = new TreeNode(root.val);
        if(root.children != null && root.children.size() != 0) {
            res.left = encodeHelper(root.children.get(0), root.children, 1);
        }
        if(brothers != null && index < brothers.size()) {
            res.right = encodeHelper(brothers.get(index++), brothers, index);
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        List<Node> children = new LinkedList<>();
        Node res = new Node(root.val, children);
        decodeHelper(root.left, children);
        return res;
    }

    private void decodeHelper(TreeNode root, List<Node> brothers) {
        if(root == null) return;
        Node res = new Node();
        brothers.add(res);
        List<Node> children = new LinkedList<>();
        res.val = root.val;
        res.children = children;
        decodeHelper(root.left, children);
        decodeHelper(root.right, brothers);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
