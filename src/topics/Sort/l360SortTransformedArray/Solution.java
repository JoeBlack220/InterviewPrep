package topics.Sort.l360SortTransformedArray;
// merge sort
// time O(nlogn) spaceO(n)
public class Solution {
    int[] temp;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        temp = new int[nums.length];
        sort(nums, a, b, c, 0, nums.length - 1);
        return nums;
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        for(int i = lo; i <= hi; ++i) temp[i] = nums[i];
        int m = lo, n = mid + 1;
        for(int i = lo; i <= hi; ++i) {
            if(m > mid) nums[i] = temp[n++];
            else if(n > hi) nums[i] = temp[m++];
            else if(temp[n] > temp[m]) nums[i] = temp[m++];
            else nums[i] = temp[n++];
        }
    }

    private void sort(int[] nums, int a, int b, int c, int lo, int hi) {
        if(hi == lo) {
            int cur = nums[lo];
            nums[lo] = cur * cur * a + cur * b + c;
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, a, b, c, lo, mid);
        sort(nums, a, b, c, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }
}
