package topics.BreadthFirstSearch.l317ShortestDistancefromAllBuildings;
import java.util.*;
public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        int[][] total = new int[m][n];
        int[][] path = new int[m][n];
        Set<int[]> buildings = new HashSet<>();
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    buildings.add(new int[]{i, j});
                }
            }
        }

        for(int[] building: buildings) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            queue.offer(building);
            int curStep = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                curStep++;
                for(int i = 0; i < size; ++i) {
                    int[] cur = queue.poll();
                    for(int[] dir: dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] != 0) continue;
                        visited[x][y] = true;
                        total[x][y] += curStep;
                        queue.offer(new int[]{x, y});
                        path[x][y]++;
                    }
                }
            }
        }


        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 0 && path[i][j] == buildings.size()) {
                    res = Math.min(res, total[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}