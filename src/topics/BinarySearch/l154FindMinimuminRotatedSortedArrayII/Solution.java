package topics.BinarySearch.l154FindMinimuminRotatedSortedArrayII;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[l] < nums[r]) return nums[l];
            if(nums[r] > nums[mid]) r = mid;
            else if(nums[r] < nums[mid]) l = mid + 1;
            else r--;
        }
        return nums[l];
    }
}