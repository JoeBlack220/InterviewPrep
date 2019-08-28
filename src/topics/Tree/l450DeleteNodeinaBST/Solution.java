package topics.Tree.l450DeleteNodeinaBST;
import datastructure.TreeNode;
// if we find the node to delete, delete it then recursively insert right subtree into the left subtree
// if we don't find the node, recursively delete the node on the root's left subtree and right subtree
// we can also set a global flag to end the process early once we found the node to delete
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null && root.right == null) return null;
            else if(root.left != null) {
                return insert(root.left, root.right);
            }
            else return root.right;
        }
        else {
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
            return root;
        }
    }

    private TreeNode insert(TreeNode left, TreeNode right) {
        if(right == null) return left;
        if(left.right == null) {
            left.right = right;
            return left;
        }
        else {
            left.right = insert(left.right, right);
            return left;
        }
    }
}