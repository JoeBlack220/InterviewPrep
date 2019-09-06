package topics.HashTable.l560SubarraySumEqualsK;
import java.util.*;
// use the thoughts of two sum and prefix sum
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int presum = 0;

        for(int num: nums) {
            presum += num;
            res += map.getOrDefault(presum - k, 0);
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }

        return res;
    }
}