package leetcode.BinarySearch.l33SearchinRotatedSortedArray;

public class Solution {
    // 先找到最小的index，然后看最后一个数是否大于target
// 如果大于target那么就在start到minindex之间找
// 否则在minindex和最后一个元素之间找
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end -  start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
