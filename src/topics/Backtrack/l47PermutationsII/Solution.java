package topics.Backtrack.l47PermutationsII;
import java.util.*;
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(res, new ArrayList<>(), used, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> sofar, boolean[] used, int[] nums) {
        if(sofar.size() == used.length) {
            List<Integer> toAdd = new ArrayList<>(sofar);
            res.add(toAdd);
        }

        else {
            for(int i = 0; i < used.length; ++i) {
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                else{
                    used[i] = true;
                    sofar.add(nums[i]);
                    helper(res, sofar, used, nums);
                    sofar.remove(sofar.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}