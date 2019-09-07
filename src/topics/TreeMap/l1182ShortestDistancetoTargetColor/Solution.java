package topics.TreeMap.l1182ShortestDistancetoTargetColor;
import java.util.*;
public class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        TreeSet<Integer>[] dict = new TreeSet[4];
        for(int i = 1; i < 4; ++i) dict[i] = new TreeSet<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < colors.length; ++i) {
            dict[colors[i]].add(i);
        }

        for(int[] query: queries) {
            TreeSet<Integer> c = dict[query[1]];
            int candidate1 = c.floor(query[0]) == null ? Integer.MIN_VALUE / 2 : c.floor(query[0]);
            int candidate2 = c.ceiling(query[0]) == null ? Integer.MAX_VALUE / 2 : c.ceiling(query[0]);
            int toAdd = Math.min(query[0] - candidate1, candidate2 - query[0]);
            if(candidate1 ==  Integer.MIN_VALUE / 2 && candidate2 == Integer.MAX_VALUE / 2) res.add(-1);
            else res.add(toAdd);
        }

        return res;
    }
}