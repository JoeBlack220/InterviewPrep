package topics.DepthFirstSearch.l329LongestIncreasingPathinaMatrix;

public class Solution {
    private int m;
    private int n;
    private int[][] memo;
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(i, j, matrix));
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] matrix) {
        if(memo[i][j] != 0) return memo[i][j];
        int res = 0;
        for(int[] dir: dirs) {
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            if(next_i < 0 || next_i >= m || next_j < 0 || next_j >= n || matrix[i][j] >= matrix[next_i][next_j]) continue;
            else res = Math.max(res, dfs(next_i, next_j, matrix));
        }
        memo[i][j] = res + 1;
        return memo[i][j];
    }
}
