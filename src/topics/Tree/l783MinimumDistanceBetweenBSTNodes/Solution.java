package topics.Tree.l783MinimumDistanceBetweenBSTNodes;
import datastructure.TreeNode;
public class Solution {
    int res = Integer.MAX_VALUE;
    // record the biggest value in the left subtree and the smallest value in the right subtree
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return res;
    }

    private Pair helper(TreeNode root) {
        if(root == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if(left.max != Integer.MIN_VALUE) res = Math.min(res, root.val - left.max);
        if(right.min != Integer.MAX_VALUE) res = Math.min(res, right.min - root.val);
        return new Pair(Math.min(left.min, root.val), Math.max(right.max, root.val));
    }

    class Pair {
        int min;
        int max;
        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    // or we can use a value to record the previous value of inorder traversal of the current node
    // since it's a BST so inorder traversal will give the numbers in the right order
    // so the minimum difference must be between a node and it's previous node in inorder traversal
    Integer res2 = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST1(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res2 = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}