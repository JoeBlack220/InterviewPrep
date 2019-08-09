package topics.Tree.l530MinimumAbsoluteDifferenceinBST;
import datastructure.TreeNode;
public class Solution {
    // exactly same as l783
    Integer res = Integer.MAX_VALUE, pre = null;
    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) getMinimumDifference(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) getMinimumDifference(root.right);
        return res;
    }
}
