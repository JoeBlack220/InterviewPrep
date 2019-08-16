package topics.DynammicProgramming.l546RemoveBoxes;

public class Solution {
    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][][] dp = new int[len][len][len];
        return dfs(dp, 0, len - 1, 0, boxes);
    }

    private int dfs(int[][][] dp, int i, int j, int k, int[] boxes) {
        if(i > j) return 0;
        if(dp[i][j][k] != 0) return dp[i][j][k];
        while(i < j && boxes[j] == boxes[j - 1]) {
            j--;
            k++;
        }
        dp[i][j][k] = (k + 1) * (k + 1) + dfs(dp, i, j - 1, 0, boxes);
        for(int m = i; m < j; ++m) {
            if(boxes[m] == boxes[j]) {
                dp[i][j][k] = Math.max(dp[i][j][k], dfs(dp, i, m, k + 1, boxes) +  dfs(dp, m + 1, j - 1, 0, boxes));
            }
        }
        return dp[i][j][k];
    }
}
