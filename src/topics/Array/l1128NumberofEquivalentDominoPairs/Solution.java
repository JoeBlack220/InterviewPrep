package topics.Array.l1128NumberofEquivalentDominoPairs;
import java.util.*;
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int[] d: dominoes) {
            int sig = 0;
            if(d[0] <= d[1]) sig = d[0] * 9 + d[1];
            else sig = d[1] * 9 + d[0];
            int curCount = map.getOrDefault(sig, 0);
            count += curCount;
            map.put(sig, curCount + 1);
        }
        return count;
    }
}
