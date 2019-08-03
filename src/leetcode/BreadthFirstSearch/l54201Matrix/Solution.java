package leetcode.BreadthFirstSearch.l54201Matrix;
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    // first include all the 0 in the matrix to the queue
    // then add all 1s who have a neighbor that is zero, at the same time set the
    // entry in the original matrix to 0
    // increment the current distance so the 1s found in the next iteration who has a
    // zero neighbor will have larger distance
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        int curDis = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                for(int[] dir: dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && matrix[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                        res[nextX][nextY] = curDis;
                        matrix[nextX][nextY] = 0;
                    }
                }
            }
            curDis++;
        }
        return res;
    }
}