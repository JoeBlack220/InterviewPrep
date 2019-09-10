package topics.Tree.l199BinaryTreeRightSideView;
import java.util.*;
import datastructure.TreeNode;
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, 0, root);
        return res;
    }

    private void helper(List<Integer> res, int index, TreeNode root) {
        if(root == null) return;
        if(index == res.size()) res.add(root.val);
        else res.set(index, root.val);
        helper(res, index + 1, root.left);
        helper(res, index + 1, root.right);
    }
}