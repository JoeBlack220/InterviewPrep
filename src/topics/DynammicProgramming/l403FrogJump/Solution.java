package topics.DynammicProgramming.l403FrogJump;
import java.util.*;
// dp solution
public class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int num: stones) {
            map.put(num, new HashSet<>());
        }
        map.get(0).add(0);
        for(int i = 0; i < stones.length; ++i) {
            Set<Integer> curSet = map.get(stones[i]);
            for(int jump: curSet) {
                for(int j = -1; j <= 1; ++j) {
                    int nextJump = jump + j;
                    // System.out.println(entry.getKey() + "," + nextJump);
                    if(nextJump <= 0 || !map.containsKey(stones[i] + nextJump)) continue;
                    // System.out.println(entry.getKey() + "," + nextJump);
                    map.get(stones[i] + nextJump).add(nextJump);
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}

// dfs solution
class Solution2 {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {return false;}
        int n = stones.length;
        if (n == 1) {return true;}
        if (stones[1] != 1) {return false;}
        if (n == 2) {return true;}
        int last = stones[n - 1];
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < n; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;} // The two stones are too far away.
            hs.add(stones[i]);
        }
        return canReach(hs, last, 1, 1);
    }

    private boolean canReach(HashSet<Integer> hs, int last, int pos, int jump) {
        if (pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) {
            return true;
        }
        if (hs.contains(pos + jump + 1)) {
            if (canReach(hs, last, pos + jump + 1, jump + 1)) {return true;}
        }
        if (hs.contains(pos + jump)) {
            if (canReach(hs, last, pos + jump, jump)) {return true;}
        }
        if (jump > 1 && hs.contains(pos + jump - 1)) {
            if (canReach(hs, last, pos + jump - 1, jump - 1)) {return true;}
        }
        return false;
    }
}