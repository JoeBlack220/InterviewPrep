package topics.DynammicProgramming.l688KnightProbabilityInChessBoard;

public class Solution {
    int[][] direction = new int[][] {{-1, -2},{-1,2},{1, -2},{1, 2},{-2, -1},{-2, 1},{2, -1},{2, 1}};
    public double knightProbability(int N, int K, int r, int c) {
        Double[][][] mem = new Double[N][N][K+1];
        return dfs(N, K, r, c, mem);
    }
    private double dfs(int N, int K, int r, int c, Double[][][] mem) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return 0.0;
        }
        if (K == 0) {
            return 1.0;
        }
        double res = 0.0;

        if (mem[r][c][K] != null) {
            return mem[r][c][K];
        }
        for (int [] dir: direction) {
            res += dfs (N, K-1, r + dir[0], c + dir[1], mem);
        }
        mem[r][c][K] = res * 0.125;
        return res * 0.125;

    }
}
