package topics.DynammicProgramming.l516LongestPalindromicSubsequence;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int l = 0; l < len; ++l) {
            for(int i = 0; i < len - l; ++i) {
                int j = i + l;
                if(s.charAt(i) == s.charAt(j)) {
                    if(l <= 1) dp[i][j] = l + 1;
                    else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }
                else {
                    if(l <= 1) dp[i][j] = 1;
                    else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}