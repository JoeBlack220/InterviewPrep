package leetcode.Tree.l1123LowestCommonAncestorOfDeepestLeaves;
import datastructure.TreeNode;
public class Solution {
    int depth = 0;
    int count = 0;
    TreeNode res = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        helper2(root, 0);
        return res;
    }

    private void helper(TreeNode root, int cur) {
        if(root == null) return;
        if(cur > depth) {
            count = 1;
            depth = cur;
        }
        else if(cur == depth) {
            count++;
        }
        helper(root.left, cur + 1);
        helper(root.right, cur + 1);
    }

    private int helper2(TreeNode root, int cur) {
        if(root == null) return 0;
        int sum = 0;
        if(cur == depth) sum++;
        sum += helper2(root.right, cur + 1) + helper2(root.left, cur + 1);
        if(sum == count && res == null) {
            // System.out.println("get here");
            res = root;
        }
        return sum;

    }
}