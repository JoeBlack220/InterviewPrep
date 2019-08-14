package topics.Graph.l778SwiminRisingWater;
import java.util.*;
public class Solution {
    // dijistra + bfs
    // time O(n^2logn) space O(n)
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.elevation - b.elevation));
        pq.offer(new Pair(grid[0][0], 0));
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int curX = cur.coor / n;
            int curY = cur.coor % n;
            visited.add(cur.coor);
            max = Math.max(grid[curX][curY], max);
            if(visited.contains(m * n - 1)) return max;
            for(int[] dir: dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                int nextCoor = nextX * n + nextY;
                if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited.contains(nextCoor)) continue;
                pq.offer(new Pair(grid[nextX][nextY], nextCoor));
            }
        }
        return -1;
    }

    class Pair {
        int elevation;
        int coor;
        public Pair(int e, int c) {
            elevation = e;
            coor = c;
        }
    }
}
