package leetcode.Tree.l285InorderSuccessorInBST;
import datastructure.TreeNode;
import java.util.List;
import java.util.LinkedList;
public class Solution {
    // inorder traverse the whole tree and add the nodes to a linked list
    // then use the linked list to find the node which is the successor of the
    // assigned node
    // time O(n) beats 14.46% space O(n) beats 49.68%

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new LinkedList<>();
        helper(list, root);
        boolean flag = false;
        for(TreeNode cur: list) {
            // System.out.println(cur.val);
            if(cur == p) {
                flag = true;
            }
            else if(flag) {
                return cur;
            }
        }
        return null;
    }

    private void helper(List<TreeNode> list, TreeNode root) {
        if(root == null) return;
        helper(list, root.left);
        list.add(root);
        helper(list, root.right);

    }

    // optimization: could find the node during the traverse
    // time beats 100% space beats 5.11%
    boolean flag = false;
    TreeNode res = null;
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        helper(root, p);
        return res;
    }

    private void helper(TreeNode root, TreeNode p) {
        if(root == null) return;
        helper(root.left, p);
        if(root == p) flag = true;
        else if(flag) {
            if(res == null) res = root;
            else return;
        }
        helper(root.right, p);
    }

    // could do without the helper function and the flag
    // time and space are the same as before
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root!=null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }
}
