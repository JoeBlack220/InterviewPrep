package leetcode.DynammicProgramming.l1137NthTribonacciNumber;

public class Solution {
    // easy dp
    // time O(n) space O(n)
    // could be done in space O(1)
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for(int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
    // space O(1) solution
    public int tribonacci1(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
