package topics.Tree.l145BinaryTreePostorderTraversal;
import java.util.*;
import datastructure.TreeNode;
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }
}

class Solution2 {
    // postorder left, right, root
    // just like pre order, but insert in reverse order
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur != null) {
                res.add(0, cur.val);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
        return res;
    }
}