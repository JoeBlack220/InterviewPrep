package topics.DynammicProgramming.knapsack.knapsack012;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[] dp = new int[m + 1];
        for(int i = 0; i < A.length; ++i) {
            for(int j = m; j >= 0; --j) {
                int cur = j - A[i];
                if(cur < 0) continue;
                dp[j] = Math.max(dp[j], dp[cur] + V[i]);
            }
        }
        return dp[m];
    }
}