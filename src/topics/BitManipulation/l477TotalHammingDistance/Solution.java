package topics.BitManipulation.l477TotalHammingDistance;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; ++i) {
            int bitCount = 0;
            int curBit = 1 << i;
            for(int num: nums) {
                if((curBit & num) > 0) bitCount ++;
            }
            res += (bitCount) * (nums.length - bitCount);
        }
        return res;
    }

}