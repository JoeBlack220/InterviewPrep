package topics.Array.l54SpiralMatrix;
import java.util.*;
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        helper(res, matrix, 0, 0, 0, dirs, new boolean[matrix.length][matrix[0].length]);
        return res;
    }

    private void helper(List<Integer> res, int[][] matrix, int d, int x, int y, int[][] dirs, boolean[][] visited) {
        if(!visited[x][y]) {
            visited[x][y] = true;
            res.add(matrix[x][y]);
        }
        if(res.size() == matrix.length * matrix[0].length) return;
        int[] dir = dirs[d];
        x += dir[0];
        y += dir[1];
        while(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y]) {
            visited[x][y] = true;
            res.add(matrix[x][y]);
            x += dir[0];
            y += dir[1];
        }
        x -= dir[0];
        y -= dir[1];
        helper(res, matrix, (d + 1) % 4, x, y, dirs, visited);
    }
}
