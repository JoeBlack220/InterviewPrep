package leetcode.BinarySearch.l35SearchInsertPosition;

public class Solution {

    // typical binary search problems
    // if we don't find the target the target should be inserted after
    // the greatest element that is smaller than it
    // it's binary search template1, the lo will finally be 1 position large
    // than mid(and hi), it should be the return value
    // time O(logN) space O(1)
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int mid = 0;
        while(lo <= hi){
            mid = (lo + hi) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else if(nums[mid] > target) hi = mid - 1;
            else return mid;
        }
        return lo;
    }
}