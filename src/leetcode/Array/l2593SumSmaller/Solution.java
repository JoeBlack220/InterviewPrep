package leetcode.Array.l2593SumSmaller;
import java.util.Arrays;
public class Solution {
    // similar to leetcode 611 Valid Triangle Number
    // see the differences between two questions
    // time O(nlogn) 63.34% space O(1) 99.79%
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}