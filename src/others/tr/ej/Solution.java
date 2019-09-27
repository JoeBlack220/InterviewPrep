package others.tr.ej;

public class Solution {
    public int solve(int[] len, int[] weights, int p) {
        int[] dp = new int[p + 1];
        for(int i = 0; i < len.length; ++i) {
            int curLen = 2 * len[i];
            for(int j = p; j >= curLen; --j) {
                dp[j] = Math.max(dp[j], dp[j - curLen] + weights[i]);
            }
        }

        int res = 0;
        for(int val: dp) res = Math.max(val, res);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] len = new int[]{3, 3, 2, 2};
        int[] weights = new int[]{3, 3, 2, 2};
        System.out.println(sol.solve(len, weights, 9));
        int[] weights2 = new int[]{1, 4, 2, 5, 3};
        int[] len2 = new int[]{2, 6, 4, 7, 1};
        System.out.println(sol.solve(len2, weights2, 13));
    }
}
