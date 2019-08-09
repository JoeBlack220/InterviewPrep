package topics.Tree.l1120MaximumAverageSubtree;
import datastructure.TreeNode;
public class Solution {
    // easy dfs
    // space O(n) 100% time O(n) 100%
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0;
        else return helper(root).maxAverage;
    }

    public Result helper(TreeNode root) {
        if(root == null) return new Result(0, 0, 0);
        Result left = helper(root.left);
        Result right = helper(root.right);
        int num = left.nodeNum + right.nodeNum + 1;
        double curAverage = (left.nodeNum * left.curAverage +
                right.nodeNum * right.curAverage + root.val) / num;
        double maxAverage = Math.max(curAverage, Math.max(left.maxAverage, right.maxAverage));
        return new Result(num, curAverage, maxAverage);
    }

    class Result {
        int nodeNum;
        double curAverage;
        double maxAverage;
        public Result(int nodeNum, double curAverage, double maxAverage) {
            this.nodeNum = nodeNum;
            this.curAverage = curAverage;
            this.maxAverage = maxAverage;
        }
    }
}
