package leetcode.Backtrack.l39CombinationSum;
import java.util.*;
public class Solution {
    // straightforward backtracking
    // time ? space ?
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) return res;
        Arrays.sort(candidates);
        helper(new LinkedList<>(), target, 0, candidates);
        return res;
    }

    private void helper(List<Integer> cur, int dis, int curIndex, int[] candidates) {
        if(dis == 0) {
            res.add(new LinkedList<>(cur));
            return;
        }
        if(candidates[curIndex] > dis) return;
        for(int i = curIndex; i < candidates.length; ++i) {
            dis -= candidates[i];
            cur.add(candidates[i]);
            helper(cur, dis, i, candidates);
            dis += candidates[i];
            cur.remove(cur.size() - 1);
        }
    }
}