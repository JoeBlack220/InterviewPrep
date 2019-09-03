package topics.DepthFirstSearch.l675CutOffTreesforGolfEvent;
import java.util.*;
public class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i = 0; i < forest.size(); ++i) {
            for(int j = 0; j < forest.get(0).size(); ++j) {
                if(forest.get(i).get(j) > 1) pq.offer(new int[]{i, j, forest.get(i).get(j)});
            }
        }

        // if(pq.peek()[0] != 0 || pq.peek()[1] != 0) {
        //     System.out.println(pq.peek()[2]);
        //     return -1;
        // }
        int res = 0;
        int[] last = new int[]{0, 0};
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int inc = bfs(forest, last, cur);
            // System.out.println(inc);
            if(inc < 0) return -1;
            res += inc;
            last[0] = cur[0];
            last[1] = cur[1];
        }
        return res;
    }

    private int bfs(List<List<Integer>> forest, int[] start, int[] end) {
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                if(cur[0] == end[0] && cur[1] == end[1]) return step;
                for(int[] dir: dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if(nextX < 0 || nextX >= forest.size() || nextY < 0 || nextY >= forest.get(0).size() || forest.get(nextX).get(nextY) == 0 || visited[nextX][nextY]) continue;
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
            step++;

        }
        return -1;
    }
}