package topics.Array.l26RemoveDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        if(nums.length == 0) return 0;
        int last = nums[0] == 0 ? 1 : 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != last) {
                last = nums[i];
                nums[index++] = last;
            }
        }
        return index;
    }
}
