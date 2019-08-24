package topics.BinarySearch.l410SplitArrayLargestSum;
import java.util.*;

// solution 1 dp
// dp[i][j] := ans of sub-problem, splitting nums[0] ~ nums[j] into i groups
// dp[1][j] = sum(0, j)
// dp[i][j] = min{max{dp[i - 1][k], sum(k + 1, j))}} 0 <= k < j
// space O(mn) time O(mn^2)
public class Solution {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[] prefix = new int[len];
        prefix[0] = nums[0];
        for(int i = 1; i < len; ++i) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int[][] dp = new int[m][len];
        for(int[] temp: dp) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        dp[0] = prefix;
        for(int i = 1; i < m; ++i) {
            for(int j = 0; j < len; ++j) {
                for(int k = 0; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], prefix[j] - prefix[k]));
                }
            }
        }
        return dp[m - 1][len - 1];
    }
}


// solution 2 binary search
// since all the numbers in the array are non-negative numbers
// the answer must be in the range [l = max(nums), r = sum(nums) + 1)
// we can just direct search the answer
// given a candidate C(the minimum sum of all the array), compute the number groups k needed
// use greedy partition to split the array
// if k > m: C too small
//      l = C + 1
// else
//      l = C
// time O(log(sum(nums))*n)
// space O(1)

class Solution2 {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE, len = nums.length;
        int sum = 0;
        for(int i = 0; i < len; ++i) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        int l = max, r = sum, c = 0;
        // find the smallest candidate that we can split the subarray into m parts
        // and every part is smaller or equal to the sum
        while(l <= r) {
            c = l + (r - l) / 2;
            if(helper(nums, c) > m) {
                l = c + 1;
            }
            else {
                r = c - 1;
            }
        }
        return l;
    }
    // we use helper to find the number of splits we need if we have every split subarray has sum less or equal
    // than candidate
    private int helper(int[] nums, int candidate) {
        int total = 0;
        int res = 1;
        for(int num :nums) {
            total += num;
            if(total > candidate) {
                total = num;
                res++;
            }
        }
        return res;
    }
}