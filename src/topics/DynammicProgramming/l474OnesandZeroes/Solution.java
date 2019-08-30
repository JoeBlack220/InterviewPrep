package topics.DynammicProgramming.l474OnesandZeroes;

public class Solution {
    // 2d 0-1 knapsack, iterate from back to start
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[][] counts = count01(strs);
        for(int[] count: counts) {
            for(int i = m; i >= count[0]; --i) {
                for(int j = n; j >= count[1]; --j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[][] count01(String[] strs) {
        int[][] res = new int[strs.length][2];
        for(int i = 0; i < strs.length; ++i) {
            for(char c: strs[i].toCharArray()) {
                if(c == '0') res[i][0]++;
                if(c == '1') res[i][1]++;
            }
        }
        return res;
    }
}
