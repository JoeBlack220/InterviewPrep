package topics.Tree.l94BinaryTreeInorderTraversal;
import java.util.*;
import datastructure.TreeNode;
// solution1 recursively add the nodes
public class Solution {
    // inorder: left, root, right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}

// use a stack to iteratively traverse
class Solution2 {
    // inorder: left, root, right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
