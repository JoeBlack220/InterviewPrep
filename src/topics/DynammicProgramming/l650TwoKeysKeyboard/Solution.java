package topics.DynammicProgramming.l650TwoKeysKeyboard;
import java.util.*;
public class Solution {
    public int minSteps(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int[] d: dp) Arrays.fill(d, Integer.MAX_VALUE / 2);
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < n; ++j) {
                if(dp[i][j] >= Integer.MAX_VALUE / 2) continue;
                int n_cop = i;
                int n_num = i + j;
                if(n_cop <= n) {
                    dp[i][n_cop] = Math.min(dp[i][n_cop], dp[i][j] + 1);
                }
                if(n_num <= n) {
                    dp[n_num][j] = Math.min(dp[n_num][j], dp[i][j] + 1);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= n; ++i) {
            res = Math.min(res, dp[n][i]);
        }
        return res;
    }

}
// recursively
class Solution2 {
    public int minSteps(int n) {
        if(n<=1){
            return 0;
        }
        for(int i=2; i<n; i++){
            if(n%i==0){
                return minSteps(n/i) + i;
            }
        }
        return n;
    }
}