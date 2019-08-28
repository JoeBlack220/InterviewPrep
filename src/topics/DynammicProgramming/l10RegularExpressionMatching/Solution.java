package topics.DynammicProgramming.l10RegularExpressionMatching;
// similar to wildcard match
// need to think thoroughly of every possible match situation
public class Solution {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for(int i = 1; i < plen; i+=2) {
            if(p.charAt(i) == '*') {
                dp[0][i + 1] = true;
            }
            else break;
        }

        for(int i = 1; i <= slen; ++i) {
            for(int j = 1; j <= plen; ++j) {
                if(matches(s.charAt(i - 1), p.charAt(j - 1))) {
                    if(j > 2 && p.charAt(j - 2) == '*') dp[i][j] = dp[i - 1][j - 3];
                    dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = (matches(s.charAt(i - 1), p.charAt(j - 2)) && dp[i - 1][j] || dp[i][j - 2]);
                }
            }
        }
        return dp[slen][plen];
    }

    private boolean matches(char s1, char p1) {
        return (s1 == p1 || p1 == '.');
    }
}
