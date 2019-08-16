package topics.DynammicProgramming.l964LeastOperatorstoExpressNumber;
import java.util.*;
public class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        return dfs(dp, x, target);

    }

    private int dfs(Map<Integer, Integer> map, int x, int target) {
        if(map.containsKey(target)) return map.get(target);
        int k = (int) (Math.log(target) / Math.log(x));
        if(target == 0) return 0;
        else if(k == 0) {
            map.put(target, Math.min(2 * target - 1, (x - target) * 2));
        }
        else if((int)(Math.pow(x, k)) == target) {
            map.put(target, k - 1);
        }
        else {
            int next1 = (int) (Math.pow(x, k + 1) - target);
            int next2 = (int) (target - Math.pow(x, k));
            if(next1 < target) {
                map.put(target, Math.min(dfs(map, x, next1) + k + 1, dfs(map, x, next2) + k));
            }
            else {
                map.put(target, dfs(map, x, next2) + k);
            }
        }
        return map.get(target);
    }
}
