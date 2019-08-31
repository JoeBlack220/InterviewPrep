package topics.Array.l268MissingNumber;

public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (len * len + len) / 2;
        for(int num: nums) sum -= num;
        return sum;
    }
}