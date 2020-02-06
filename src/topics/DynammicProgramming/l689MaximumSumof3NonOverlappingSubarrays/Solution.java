package topics.DynammicProgramming.l689MaximumSumof3NonOverlappingSubarrays;

// sum[i]: subarray sum from i to i + k - 1
// left[i]: the index of the maximum value of sum from index 0 to i
// right[i]: the index of maximum value of sum from index i to len - 1
// max value of three non-overlap arrays
// max(sum[left[i - k]] + sum[i] + sum[right[i + k]]) for i in range[k, len - 2 * k]
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] left = new int[len], right = new int[len];
        int[] sum = new int[len];

        int cur = 0;
        for(int i = 0; i < k; ++i) cur+= nums[i];
        sum[0] = cur;

        for(int i = 0; i < len - k; i++) {
            cur -= nums[i];
            cur += nums[i + k];
            sum[i + 1] = cur;
        }

        int max = Integer.MIN_VALUE;
        int curIndex = -1;
        for(int i = 0; i < len - k; ++i) {
            if(sum[i] > max) {
                curIndex = i;
                max = sum[i];
            }
            left[i] = curIndex;
        }

        max = Integer.MIN_VALUE;
        for(int i = len - k; i >= 0; --i) {
            if(sum[i] >= max) {
                curIndex = i;
                max = sum[i];
            }
            right[i] = curIndex;
        }

        int curMax = Integer.MIN_VALUE;
        int[] res = new int[3];
        for(int i = k; i <= len - 2 * k; ++i) {
            if(sum[left[i - k]] + sum[i] + sum[right[i + k]] > curMax) {
                curMax = sum[left[i - k]] + sum[i] + sum[right[i + k]];
                res = new int[]{left[i - k], i, right[i + k]};
            }
        }
        return res;


    }
}