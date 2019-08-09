package topics.Tree.l298BinaryTreeLongestConsecutiveSequence;
import datastructure.TreeNode;
public class Solution {
    // straightforward traverse the tree
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        else {
            if(root.val == 0) return helper(root, 1, 1, 1);
            else return helper(root, 1, -1, 1);
        }
    }

    private int helper(TreeNode root, int max, int lastVal, int cur) {
        if(root == null) return max;
        // System.out.println(root.val + "." + max);
        if(root.val == lastVal + 1) {
            return Math.max(helper(root.left, Math.max(max, cur + 1), root.val, cur + 1),
                    helper(root.right, Math.max(max, cur + 1), root.val, cur + 1));
        }
        else {
            return Math.max(helper(root.left, max, root.val, 1),
                    helper(root.right, max, root.val, 1));
        }
    }
}
