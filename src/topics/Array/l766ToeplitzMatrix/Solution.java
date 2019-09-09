package topics.Array.l766ToeplitzMatrix;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; ++i) {
            if(!helper(matrix, 0, i, matrix[0][i])) return false;
        }

        for(int j = 1; j < matrix.length; ++j) {
            if(!helper(matrix, j, 0, matrix[j][0])) return false;
        }

        return true;
    }

    private boolean helper(int[][] matrix, int i, int j, int num) {
        if(i >= matrix.length || j >= matrix[0].length) return true;
        if(matrix[i][j] != num) return false;

        return helper(matrix, i + 1, j + 1, num);
    }

}