package topics.BitManipulation.l136SingleNumber;

// a number xor itself would be zero
// zero xor itself would be itself
// the left element should be the only element that appears only once
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
        }
        return res;
    }
}