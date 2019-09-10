package topics.Tree.l114FlattenBinaryTreetoLinkedList;
import datastructure.TreeNode;
public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(prev != null) prev.right = root;
        prev = root;
        root.left = null;
        flatten(left);
        flatten(right);
    }
}