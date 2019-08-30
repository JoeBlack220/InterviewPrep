package topics.Tree.l101SymmetricTree;
import datastructure.TreeNode;
import java.util.*;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        else if(l == null || r == null) return false;
        else if(l.val != r.val) return false;
        else {
            return helper(l.left, r.right) && helper(l.right, r.left);
        }
    }
}
// iterative solution
class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}