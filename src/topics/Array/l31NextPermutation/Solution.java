package topics.Array.l31NextPermutation;

public class Solution {
//    the next permutation is the smallest permutation that is bigger than the current permutation
//    Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
//    Find the largest index l > k such that nums[k] < nums[l].
//    Swap nums[k] and nums[l].
//    Reverse the sub-array nums[k + 1:].

    // other permutations problems are basic backtracking
    // this needs extra knowledge about how to compute the next permutation
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int largest = findNextLargest(nums);
        if(largest == -1) {
            reverse(nums, 0);
            return;
        }
        int larger = 0;
        for(int i = nums.length - 1; i > largest; i--) {
            if(nums[i] > nums[largest]) {
                larger = i;
                break;
            }
        }
        exch(nums, largest, larger);
        reverse(nums, largest + 1);
    }

    private int findNextLargest(int[] nums) {
        int res = -1;
        for(int i = nums.length - 2; i >= 0; --i) {
            if(nums[i + 1] > nums[i]) return i;
        }
        return res;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(start < end) {
            exch(nums, start++, end--);
        }
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
