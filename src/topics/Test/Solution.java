package topics.Test;
import java.util.*;
import datastructure.*;

class Solution {
    public int countVowelPermutation(int n) {
        int[] dp = new int[5];
        int mod = (int) 1e9 + 7;
        Arrays.fill(dp, 1);
        for(int i = 2; i <= n; ++i) {
            int[] next = new int[5];
            next[0] = (dp[1] + dp[2] + dp[4]) % mod;
            next[1] = (dp[0] + dp[2]) % mod;
            next[2] = (dp[1] + dp[3]) % mod;
            next[3] = (dp[2]) % mod;
            next[4] = (dp[2] + dp[3]) % mod;
            dp = next;
        }

        int res = 0;
        for(int num: dp) {
            res = res + num;
            res %= mod;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

    }
}

