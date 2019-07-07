package cc189.chapter1;

public class RotateMatrix {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] test = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        sol.rotate((test));
        for(int[] r: test) {
            for(int c: r) System.out.println(c);
        }
    }

    static class Solution {
        // space O(1) time O(n^2)
        public boolean rotate(int[][] matrix) {
            if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
            int n = matrix.length;
            for (int layer = 0; layer < n / 2; ++layer) {
                int first = layer;
                int last = n - 1 - layer;
                for (int i = first; i < last; ++i) {
                    int offset = i - first;
                    int top = matrix[first][i];
                    matrix[first][i] = matrix[last - offset][first];
                    matrix[last - offset][first] = matrix[last][last - offset];
                    matrix[last][last - offset] = matrix[i][last];
                    matrix[i][last] = top;
                }
            }
            return true;
        }
    }
}
