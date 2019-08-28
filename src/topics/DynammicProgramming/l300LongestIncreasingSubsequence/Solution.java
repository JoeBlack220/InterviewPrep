package topics.DynammicProgramming.l300LongestIncreasingSubsequence;
import java.util.*;
// dp solution
// time O(n^2)
// space O(n)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
    // solution2 binary search + dp time O(nlogn)
    public int lengthOfLIS2(int[] nums) {
        //  tails is an array storing the smallest tail of all increasing
        //  subsequence with length i+1 in tails[i].
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
