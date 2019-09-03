package topics.DynammicProgramming.l514FreedomTrail;
import java.util.*;
public class Solution {
    public int findRotateSteps(String ring, String key) {
        int rLen = ring.length(), kLen = key.length();
        List<Integer>[] dict = new List[26];

        for(int i = 0; i < 26; ++i) {
            dict[i] = new ArrayList<>();
        }

        for(int i = 0; i < rLen; ++i) {
            dict[ring.charAt(i) - 'a'].add(i);
        }

        int[][] dp = new int[kLen][rLen];
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < kLen; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 3);
            for(int num: dict[key.charAt(i) - 'a']) {
                if(i == 0) dp[i][num] = Math.min(dp[i][num], Math.min(Math.abs(rLen - num) + 1, num + 1));
                else {
                    for(int index: dict[key.charAt(i - 1) - 'a']) {
                        int candidate = Math.min(Math.abs(index - num) + 1, rLen - Math.abs(index - num) + 1);
                        dp[i][num] = Math.min(dp[i][num], candidate + dp[i - 1][index]);
                    }
                }
                if(i == kLen - 1) res = Math.min(dp[i][num], res);
            }
        }
        return res;
    }
}