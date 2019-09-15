package topics.BitManipulation.l540SingleElementinaSortedArray;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for(int num : nums) res ^= num;
        return res;
    }
}