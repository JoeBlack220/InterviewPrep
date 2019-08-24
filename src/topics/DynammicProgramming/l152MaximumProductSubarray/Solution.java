package topics.DynammicProgramming.l152MaximumProductSubarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < len; ++i) {
            if(i == 0) {
                dp_max[i] = nums[i];
                dp_min[i] = nums[i];
            }
            else {
                int candidate1 = dp_max[i - 1] * nums[i];
                int candidate2 = dp_min[i - 1] * nums[i];
                int candidate3 = nums[i];
                dp_max[i] = Math.max(candidate3, Math.max(candidate1, candidate2));
                dp_min[i] = Math.min(candidate3, Math.min(candidate1, candidate2));
            }
            res = Math.max(res, dp_max[i]);
        }
        return res;
    }
}
