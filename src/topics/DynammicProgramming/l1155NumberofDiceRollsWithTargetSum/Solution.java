package topics.DynammicProgramming.l1155NumberofDiceRollsWithTargetSum;

public class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= d; ++i) {
            for(int j = 1; j <= target; ++j) {
                int res = 0;
                for(int k = 1; k <= f; ++k) {
                    int cur = j - k;
                    if(cur < 0) continue;
                    dp[i][j] += dp[i - 1][cur];
                    dp[i][j] = dp[i][j] % mod;
                }
            }
        }
        return dp[d][target] % mod;
    }
}