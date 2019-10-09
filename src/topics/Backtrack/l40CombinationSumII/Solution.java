package topics.Backtrack.l40CombinationSumII;
import java.util.*;
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, 0, target, new LinkedList<>(), candidates);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int curIndex, int target, List<Integer> sofar, int[] candidates) {
        if(target == 0) {
            List<Integer> toAppend = new ArrayList<>(sofar);
            res.add(toAppend);
        }

        if(curIndex >= candidates.length || target < 0) return;

        for(int i = curIndex; i < candidates.length; ++i) {
            if(i != curIndex && candidates[i] == candidates[i - 1]) continue;
            sofar.add(candidates[i]);
            backtrack(res, i + 1, target - candidates[i], sofar, candidates);
            sofar.remove(sofar.size() - 1);
        }
    }
}