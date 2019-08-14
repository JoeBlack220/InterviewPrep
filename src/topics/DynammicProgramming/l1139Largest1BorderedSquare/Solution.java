package topics.DynammicProgramming.l1139Largest1BorderedSquare;

public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] top = new int[m][n];
        int[][] left = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    top[i][j] = (i == 0) ? 1 : top[i - 1][j] + 1;
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
                }
            }
        }
        int max = 0;
        for(int i = m - 1; i >= 0; --i) {
            for(int j = n - 1; j >= 0; --j) {
                int cur = Math.min(top[i][j], left[i][j]);
                if(cur > max){
                    while(top[i][j - cur + 1] < cur || left[i - cur + 1][j] < cur) {
                        cur--;
                    }
                }
                max = Math.max(max, cur);
            }
        }
        return max * max;
    }
}
