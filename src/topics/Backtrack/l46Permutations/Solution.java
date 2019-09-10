package topics.Backtrack.l46Permutations;
import java.util.*;
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[nums.length];
        helper(res, new ArrayList<>(), used, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> sofar, boolean[] used, int[] nums) {
        if(sofar.size() == used.length) {
            List<Integer> toAppend = new ArrayList<>(sofar);
            res.add(toAppend);
        }

        else {
            for(int i = 0; i < used.length; ++i) {
                if(!used[i]) {
                    sofar.add(nums[i]);
                    used[i] = true;
                    helper(res, sofar, used, nums);
                    sofar.remove(sofar.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}