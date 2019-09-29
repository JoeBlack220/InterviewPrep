package topics.BreadthFirstSearch.l1210MinimumMovestoReachTargetwithRotations;
import java.util.*;
public class Solution {
    public int minimumMoves(int[][] grid) {
        int ind = 0;
        int n = grid.length;
        int[][] v1 = new int[n][n];
        int[][] v2 = new int[n][n];
        if (grid[0][0] == 1 || grid[0][1] == 1) return -1;
        int[] s = new int[]{0, 0, 0, 1};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(s);
        while (queue.size() > 0) {
            ind++;
            System.out.println(ind);
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                int[] temp = queue.pollFirst();
                if (temp[3] > temp[1]) {
                    if (temp[3] == n - 1 && temp[2] == n - 1) return ind - 1;
                    if ((temp[3] + 1 < n) && grid[temp[0]][temp[3] + 1] != 1) {
                        if (v1[temp[0]][temp[3]] != 1)
                            queue.offerLast(new int[]{temp[0], temp[3], temp[0], temp[3] + 1});
                        v1[temp[0]][temp[3]] = 1;
                    }
                    if ((temp[0] + 1 < n) && grid[temp[0] + 1][temp[1]] != 1 && grid[temp[0] + 1][temp[3]] != 1) {
                        if (v2[temp[0]][temp[1]] != 1)
                            queue.offerLast(new int[]{temp[0], temp[1], temp[0] + 1, temp[1]});
                        v2[temp[0]][temp[1]] = 1;
                    }

                    if ((temp[0] + 1 < n) && grid[temp[0] + 1][temp[1]] != 1  && grid[temp[0] + 1][temp[3]] != 1) {
                        if (v1[temp[0] + 1][temp[1]] != 1)
                            queue.offerLast(new int[]{temp[0] + 1, temp[1], temp[0] + 1, temp[3]});
                        v1[temp[0] + 1][temp[1]] = 1;
                    }
                }
                else if (temp[2] > temp[0]) {
                    if ((temp[2] + 1 < n) && grid[temp[2] + 1][temp[1]] != 1) {
                        if (v2[temp[2]][temp[3]] != 1)
                            queue.offerLast(new int[]{temp[2], temp[3], temp[2] + 1, temp[3]});
                        v2[temp[2]][temp[3]] = 1;
                    }

                    if ((temp[1] + 1 < n) && grid[temp[0]][temp[1] + 1] != 1 && grid[temp[2]][temp[1] + 1] != 1) {
                        if (v1[temp[0]][temp[1]] != 1)
                            queue.offerLast(new int[]{temp[0], temp[1], temp[0], temp[1] + 1});
                        v1[temp[0]][temp[1]] = 1;
                    }

                    if ((temp[1] + 1 < n) && grid[temp[0]][temp[1] + 1] != 1 && grid[temp[2]][temp[3] + 1] != 1) {
                        if (v2[temp[0]][temp[1] + 1] != 1)
                            queue.offerLast(new int[]{temp[0], temp[1] + 1, temp[2], temp[3] + 1});
                        v2[temp[0]][temp[1] + 1] = 1;
                    }
                }
            }
        }
        return -1;
    }
}