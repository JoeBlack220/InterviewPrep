package topics.Tree.l230KthSmallestElementinaBST;
import datastructure.TreeNode;
import java.util.*;
// inorder iterate the bst, the kth number we read is the kth smallest element
// use a stack to iteratively do that, otherwise you may have unnecessary visits
// or you need a extra global var
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int index = 0;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            index++;
            if(k == index) return cur.val;
            cur = cur.right;
        }
        return cur.val;
    }
}
