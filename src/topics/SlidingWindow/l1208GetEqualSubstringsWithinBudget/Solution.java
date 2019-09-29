package topics.SlidingWindow.l1208GetEqualSubstringsWithinBudget;
import java.util.*;
public class Solution {
    public int equalSubstring(String s, String t, int k) {
        int n = s.length(), i = 0, j;
        for (j = 0; j < n; ++j) {
            k -= Math.abs(s.charAt(j) - t.charAt(j));
            if (k < 0) {
                k += Math.abs(s.charAt(i) - t.charAt(i));
                ++i;
            }
        }
        return j - i;
    }
}

class Solution2 {
    public int equalSubstring(String s, String t, int maxCost) {
        if(s.length() == 0) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] prefix = new int[s.length() + 1];
        map.put(0, 0);
        for(int i = 1; i <= s.length(); ++i) {
            prefix[i] = prefix[i - 1] + Math.abs(s.charAt(i - 1) - t.charAt(i - 1));
            map.put(prefix[i], i);
        }

        int max = 0;
        for(int i = 0; i <= s.length(); ++i) {
            int cur_cost = prefix[i];
            Map.Entry<Integer, Integer> e = map.floorEntry(cur_cost + maxCost);
            if(e == null) continue;
            else max = Math.max(e.getValue() - i, max);
        }
        return max;
    }
}