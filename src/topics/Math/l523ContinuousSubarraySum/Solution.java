package topics.Math.l523ContinuousSubarraySum;
import java.util.*;
public class Solution {
    // straight forward
    // time O(n^2) space O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; ++i) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for(int i = 0; i <= nums.length - 2; i++) {
            int left = prefix[i];
            for(int j = i + 2; j <= nums.length; ++j) {
                if(k != 0 && (prefix[j] - left) % k == 0) return true;
                if(k == 0 && prefix[j] - left == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}


class Solution2 {
    // if a % b == c && d % b == c
    // a - d = m * b
    // plus the idea from two sum
    // time O(n) spaceO(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(k != 0) sum %= k;
            Integer prev = map.get(sum);
            if(prev != null) {
                if(i - prev > 1) return true;
            }else {
                map.put(sum, i);
            }
        }
        return false;
    }
}