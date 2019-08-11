package topics.DynammicProgramming.knapsack.knapsack01;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int len = A.length;
        int[] dp = new int[m + 1];
        for(int num: A) {
            for(int i = m; i > 0; i--) {
                int cur = i - num;
                if(cur < 0) continue;
                dp[i] = Math.max(dp[i], dp[cur] + num);
            }
        }
        return dp[m];
    }
}
