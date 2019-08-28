package topics.Tree.l102BinaryTreeLevelOrderTraversal;
import java.util.*;
import datastructure.TreeNode;
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if(root == null) return;
        while(level >= res.size()) res.add(new LinkedList<>());
        res.get(level).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
    }
}