package leetcode.UnionFind.l305NumberOfIslandsII;
import java.util.*;
public class Solution {
    // straight forward union-find
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        boolean[][] visited = new boolean[m][n];
        UnionFind uf = new UnionFind(m * n);
        List<Integer> res = new LinkedList<>();
        int count = 0;
        for(int[] cur: positions) {
            if(visited[cur[0]][cur[1]]) {
                res.add(count);
                continue;
            }
            visited[cur[0]][cur[1]] = true;
            count++;
            for(int[] dir: dirs) {
                int nextX = dir[0] + cur[0];
                int nextY = dir[1] + cur[1];
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && visited[nextX][nextY]) {
                    if(!uf.union(cur[0] * n + cur[1], nextX * n + nextY)) count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    class UnionFind {
        int[] pos;
        public UnionFind(int n) {
            pos = new int[n];
            for(int i = 0; i < n; ++i) {
                pos[i] = i;
            }
        }

        public int find(int x) {
            if(pos[x] != x) {
                pos[x] = find(pos[x]);
            }
            return pos[x];
        }

        public boolean union(int x, int y) {
            int posX = find(x);
            int posY = find(y);
            if(posX == posY) return true;
            pos[posX] = posY;
            return false;
        }
    }
}