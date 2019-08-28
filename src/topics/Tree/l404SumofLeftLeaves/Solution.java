package topics.Tree.l404SumofLeftLeaves;
import datastructure.TreeNode;
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return helper(false, root);
    }

    public int helper(boolean isLeft, TreeNode root) {
        if(root == null) return 0;
        int res = helper(true, root.left) + helper(false, root.right);
        if(root.left == null && root.right == null && isLeft) res += root.val;
        return res;
    }
}