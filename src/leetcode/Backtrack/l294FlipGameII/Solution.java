package leetcode.Backtrack.l294FlipGameII;
import java.util.HashMap;
public class Solution {
    // backtrack + memoization
    // time O(n^2)
    public boolean canWin(String s) {
        HashMap<String, Boolean> h = new HashMap();
        return canWin(s.toCharArray(), h);
    }

    private boolean canWin(char[] c, HashMap<String, Boolean> h) {
        for (int i = 1; i < c.length; i++)
            if (c[i] == '+' && c[i - 1] == '+') {
                c[i] = '-'; c[i - 1] = '-';

                boolean t;
                String key = String.valueOf(c);
                if (!h.containsKey(key)) {
                    t = canWin(c, h);
                    h.put(key, t);      //System.out.println(key + " --> " + t);
                } else {
                    t = h.get(key);     //System.out.println(key + " ==> " + t);
                }   // can not directly use if (t) return true here, cuz you need to restore

                c[i] = '+'; c[i - 1] = '+';
                if (!t) return true;
            }
        return false;
    }
}
