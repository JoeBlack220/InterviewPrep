package leetcode.Array.l1144DecreaseElementsToMakeArrayZigzag;

public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int res = 0;
        int cur = 0;
        int len = nums.length;
        if(len <= 1) return 0;
        for(int i = 1; i < len; i += 2) {
            int left = nums[i - 1];
            int small = (i == len - 1) ? left : Math.min(nums[i + 1], left);
            if(nums[i] >= small) cur += nums[i] - small + 1;
        }
        res = cur;
        cur = 0;
        for(int i = 0; i < len; i += 2) {
            int right = (i == len - 1) ? nums[i - 1] : nums[i + 1];
            int left = (i == 0) ? nums[i + 1] : nums[i - 1];
            int small = Math.min(right, left);
            if(nums[i] >= small) cur += nums[i] - small + 1;
        }
        res = Math.min(cur, res);
        return res;
    }
}
