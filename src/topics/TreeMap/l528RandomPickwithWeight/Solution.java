package topics.TreeMap.l528RandomPickwithWeight;
import java.util.TreeMap;
public class Solution {
    long sum;
    TreeMap<Long, Integer> map;
    public Solution(int[] w) {
        map = new TreeMap<>();
        for(int i = 0; i < w.length; ++i) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public int pickIndex() {
        long pick = (long)(sum * Math.random()) + 1;
        return map.ceilingEntry(pick).getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */