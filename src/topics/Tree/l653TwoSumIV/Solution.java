package topics.Tree.l653TwoSumIV;
import datastructure.*;
import java.util.*;
public class Solution {
    // similar to regular two sum
    // space O(n) time O(n)
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, set, k);
    }

    private boolean helper(TreeNode root, Set<Integer> set, int k) {
        if(root == null) return false;
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return helper(root.left, set, k) || helper(root.right, set, k);
    }
}
