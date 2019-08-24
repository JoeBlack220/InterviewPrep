package topics.DepthFirstSearch.l827MakingALargeIsland;
import java.util.*;
public class Solution {
    private int m;
    private int n;
    private int[][] grid;
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        Map<Integer, Integer> map = new HashMap<>();
        int group = 2;
        Set<int[]> water = new HashSet<>();

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) map.put(group, dfs(i, j, group++));
                else if(grid[i][j] == 0) water.add(new int[]{i, j});
            }
        }
        if(water.size() == 0) return m * n;
        int res = 0;
        for(int[] cur: water) {
            int num = 1;
            Set<Integer> visited = new HashSet<>();
            for(int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || !visited.add(grid[x][y])) continue;
                else num += map.get(grid[x][y]);
            }
            res = Math.max(res, num);
        }
        return res;
    }


    private int dfs(int x, int y, int group) {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) return 0;
        int res = 1;
        grid[x][y] = group;
        for(int[] dir: dirs) {
            res += dfs(x + dir[0], y + dir[1], group);
        }
        return res;
    }

}