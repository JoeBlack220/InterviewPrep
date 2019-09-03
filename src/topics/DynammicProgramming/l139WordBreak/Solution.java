package topics.DynammicProgramming.l139WordBreak;
import java.util.*;
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> dict = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 0; i < s.length(); ++i) {
            for(int j = i + 1; j <= s.length(); ++j) {
                if(dp[i] && dict.contains(s.substring(i, j))) dp[j] = true;
            }
        }
        return dp[s.length()];
    }
}