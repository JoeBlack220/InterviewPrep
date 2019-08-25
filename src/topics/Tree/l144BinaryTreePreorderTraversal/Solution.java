package topics.Tree.l144BinaryTreePreorderTraversal;
import java.util.*;
import datastructure.TreeNode;
public class Solution {
    // preorder root, left, right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}
// using a stack, iterative
class Solution2 {
    // preorder root, left, right
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur != null) {
                res.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return res;
    }
}