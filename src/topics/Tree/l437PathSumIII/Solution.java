package topics.Tree.l437PathSumIII;
import java.util.*;
import datastructure.TreeNode;
// sol1 prefix, time O(d*n) space O(n)
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        List<Integer> prefix = new LinkedList<>();
        prefix.add(0);
        return helper(root, prefix, sum);
    }

    public int helper(TreeNode root, List<Integer> prefix, int sum) {
        if(root == null) return 0;
        int res = 0;
        int cur = prefix.get(prefix.size() - 1) + root.val;
        for(int i = 0; i < prefix.size(); ++i) {
            if(cur - prefix.get(i) == sum) res++;
        }
        prefix.add(cur);
        res += helper(root.left, prefix, sum);
        res += helper(root.right, prefix, sum);
        prefix.remove(prefix.size() - 1);
        return res;
    }
}
// sol2 recursion time O(n^2)
class Solution2 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
// sol3, the first solution can be optimize, since it iterate the whole prefix array all the time to find a target
// can use the thoughts from two sum
// using a hash map can do that in O(1) time
// time O(n) space O(n)
class Solution3 {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}