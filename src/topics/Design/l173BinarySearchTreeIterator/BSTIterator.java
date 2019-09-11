package topics.Design.l173BinarySearchTreeIterator;
import java.util.*;
import datastructure.TreeNode;
public class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}