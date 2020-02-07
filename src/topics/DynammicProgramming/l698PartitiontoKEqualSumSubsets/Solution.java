package topics.DynammicProgramming.l698PartitiontoKEqualSumSubsets;
import java.util.*;
// use set to memorize the failure state and use bitmask to compress the state
// then use simple dfs to search for the answer
class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) sum += nums[i];
        if(sum % k == 0) return dfs(nums, 0, sum / k, 0, k);
        else return false;
    }

    private boolean dfs(int[] nums, int state, int target, int cur, int k) {
        if(set.contains(state)) return false;
        if(k == 0) return true;
        for(int i = 0; i < nums.length; ++i) {
            if(((1 << i) & state) == 0) {
                if(nums[i] + cur < target) {
                    if(dfs(nums, state | (1 << i), target, cur + nums[i], k)) return true;
                }
                else if(nums[i] + cur == target) {
                    if(dfs(nums, state | (1 << i), target, 0, k - 1)) return true;
                }
            }
        }
        set.add(state);
        return false;
    }
}
