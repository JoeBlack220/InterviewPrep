package topics.DynammicProgramming.l1092ShortestCommonSupersequence;

public class Solution {
    // first find the longest common sub sequence
    // reversely build the result array according to the LSC
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; ++i) {
            for(int j = 1; j <= len2; ++j) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[len1][len2]);
        int i = len1, j = len2;
        StringBuilder sb = new StringBuilder();
        while(i > 0 || j > 0) {
            if(i == 0) sb.insert(0, str2.charAt(--j));
            else if(j == 0) sb.insert(0, str1.charAt(--i));
            else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.insert(0, str2.charAt(--j));
                --i;
            }
            else if(dp[i][j] == dp[i - 1][j]) {
                sb.insert(0, str1.charAt(--i));
            }
            else {
                sb.insert(0, str2.charAt(--j));
            }
        }
        return sb.toString();
    }
}
