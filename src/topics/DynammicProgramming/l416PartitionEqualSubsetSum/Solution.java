package topics.DynammicProgramming.l416PartitionEqualSubsetSum;
import java.util.*;
// solution 1, backtrack
public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null) return false;
        if(nums.length == 0) return true;
        int sum = 0;
        for(int num: nums) sum += num;
        if((sum & 1) == 1) return false;
        return helper(nums, sum / 2, 0, 0, nums.length - 1);
    }

    private boolean helper(int[] nums, int half, int first, int second, int index) {
        if(index < 0) return first == second;
        if(first > half || second > half) return false;
        return helper(nums, half, first + nums[index], second, index - 1) ||
                helper(nums, half, first, second + nums[index], index - 1);
    }
}

// solution 2, knapsack
// for every item, we can choose to pick it or not
// if we can pick n items that sum to the half of the total sum
// we can do the partition
class Solution2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }
}