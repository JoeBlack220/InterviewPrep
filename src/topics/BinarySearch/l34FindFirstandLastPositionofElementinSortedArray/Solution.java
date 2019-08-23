package topics.BinarySearch.l34FindFirstandLastPositionofElementinSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > target) {
                l = mid + 1;
            }
            else r = mid;
        }
        if(nums[r] == target) return r;
        else return -1;
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < target) {
                r = mid + 1;
            }
            else l = mid;
        }
        if(nums[l] == target) return l;
        else return -1;
    }
}