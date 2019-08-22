package topics.Tree.l543DiameterofBinaryTree;
import datastructure.TreeNode;
// easier version of leetcode 124
public class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        else {
            int left = helper(root.left);
            int right = helper(root.right);
            max = Math.max(max, left + right);
            return left > right ? left + 1 : right + 1;
        }
    }
}
