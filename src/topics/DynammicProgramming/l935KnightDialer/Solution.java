package topics.DynammicProgramming.l935KnightDialer;
// dfs + memo
public class Solution {
    public static final int max = (int) Math.pow(10, 9) + 7;

    public int knightDialer(int n) {
        // A 3D array to store the solutions to the subproblems
        long M[][][] = new long[n + 1][4][3];
        long s = 0;
        //do n hops from every i, j index (the very requirement of the problem)
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                s = (s + paths(M, i, j, n)) % max;
            }
        }
        return (int) s;
    }

    private long paths(long[][][] M, int i, int j, int n) {
        // if the knight hops outside of the matrix or to * return 0
        //as there are no unique paths from here
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;
        if(n == 1) return 1;
        //if the subproblem's solution is already computed, then return it
        if(M[n][i][j] > 0) return M[n][i][j];
        //else compute the subproblem's solution and save it in memory
        M[n][i][j] = paths(M, i - 1, j - 2, n - 1) % max + // jump to a
                paths(M, i - 2, j - 1, n - 1) % max + // jump to b
                paths(M, i - 2, j + 1, n - 1) % max + // jump to c
                paths(M, i - 1, j + 2, n - 1) % max + // jump to d
                paths(M, i + 1, j + 2, n - 1) % max + // jump to e
                paths(M, i + 2, j + 1, n - 1) % max + // jump to f
                paths(M, i + 2, j - 1, n - 1) % max + // jump to g
                paths(M, i + 1, j - 2, n - 1) % max; // jump to h
        return M[n][i][j];
    }
}

// log n solution
// https://math.stackexchange.com/questions/1890620/finding-path-lengths-by-the-power-of-adjacency-matrix-of-an-undirected-graph
class Solution2 {

    private long[][] mult(long[][] a, long[][] b) {
        long[][] res = new long[10][10];
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                long val = 0;
                for(int k=0; k<10; k++) {
                    val += a[i][k] * b[j][k];
                }
                res[i][j] = (val % 1000000007);
            }
        }
        return res;
    }

    private long[][] pow(long[][] m, int N) {
        if(N == 1) return m;
        if(N%2 == 0) return pow(mult(m, m), N/2);
        else return mult(pow(mult(m, m), N/2), m);
    }

    public int knightDialer(int N) {
        if(N == 0) return 0;
        if(N == 1) return 10;
        long[][] mat = new long[][]{
                {0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,0,1,0,1,0},
                {0,0,0,0,0,0,0,1,0,1},
                {0,0,0,0,1,0,0,0,1,0},
                {1,0,0,1,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,1,0,0},
                {0,0,1,0,0,0,1,0,0,0},
                {0,1,0,1,0,0,0,0,0,0},
                {0,0,1,0,1,0,0,0,0,0},
        };

        long[][] resm = pow(mat, N-1);
        long res = 0;
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                res += resm[i][j];
            }
        }
        return (int) (res % 1000000007);
    }
}