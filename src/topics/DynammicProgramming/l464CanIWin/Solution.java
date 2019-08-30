package topics.DynammicProgramming.l464CanIWin;
import java.util.*;
// dfs+memoization
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;

        //A special case is if the total sum is less than desiredTotal, none of the players can win
        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) return false;

        char[] remain = new char[maxChoosableInteger + 1];
        Arrays.fill(remain, '1');
        Map<String, Boolean> map = new HashMap<>();
        return canWin(remain, map, desiredTotal);
    }

    private boolean canWin(char[] remain, Map<String, Boolean> map, int rem) {
        if (rem <= 0) return false; //means the previous person has already reach the end
        String status = new String(remain);
        //System.out.println(status);
        if (map.containsKey(status)) return map.get(status);

        boolean res = false;

        for (int i = 1; i < remain.length; i++) {
            if (remain[i] == '0') continue;
            remain[i] = '0';
            if (!canWin(remain, map, rem - i)) {// if there exist one strategy, that by taking that stategy, the second player cannot win, just take that strategy...
                res = true;
            }
            remain[i] = '1';
            if (res) break;
        }
        map.put(status, res);
        return res;
    }
}
