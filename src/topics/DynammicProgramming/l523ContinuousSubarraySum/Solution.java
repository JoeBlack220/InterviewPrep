package topics.DynammicProgramming.l523ContinuousSubarraySum;
import java.util.*;
// if you have found a previous prefix sum's mod k equals to the current prefix sum mod k
// then the current prefix sum minus the previous prefix sum can get
// a continuous subarray that can be a multiple of k
public class Solution {
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
