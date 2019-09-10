package topics.BinarySearch.l162FindPeakElement;

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length;
        while(l < r) {
            int m = l + (r - l) / 2;
            int next = m == nums.length - 1 ? Integer.MIN_VALUE : nums[m + 1];
            if(nums[m] < next) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return l;
    }
}