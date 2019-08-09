package topics.BinaryIndexedTree.l308RangeSumQuery2DMutable;

public class NumMatrix {
    int[][] tree;
    int[][] nums;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        nums = new int[m][n];
        tree = new int[m + 1][n + 1];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for(int i = row + 1; i <= m; i += lowbit(i)) {
            for(int j = col + 1; j <= n; j += lowbit(j)) {
                tree[i][j] += delta;
            }
        }

    }

    public int sum(int row, int col) {
        int res = 0;
        for(int i = row + 1; i > 0; i -= lowbit(i)) {
            for(int j = col + 1; j > 0; j -= lowbit(j)) {
                res += tree[i][j];
            }
        }
        // System.out.println(row + "," + col + "," + res);
        return res;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row1 - 1, col1 - 1) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row2, col2);
    }

    private int lowbit(int n) {
        return n & (-n);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
