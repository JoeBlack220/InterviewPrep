package topics.Sort.l280WiggleSort;

public class Solution {
    // what we want: if i is odd nums[i] >= nums[i - 1]
    //               if i is even nums[i] <= nums[i - 1]
    // so if i is odd now, we already have nums[i - 2] >= nums[i - 1]
    // 1. if nums[i - 1] <= nums[i], that's the order we want, we don't need to swap
    // 2. if nums[i - 1] >  nums[i], we can swap i - 1 and i, since nums[i - 2] >= nums[i - 1]
    // we can guarantee that the order is still maintained after the swapping
    // for even cases, it's the same
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (((i & 1) == 0) == (nums[i - 1] < nums[i])) xwap(nums, i);
    }

    private void xwap(int[] a, int i) {
        int t = a[i]; a[i] = a[i - 1]; a[i - 1] = t;
    }
}
