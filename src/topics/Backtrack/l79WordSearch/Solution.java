package topics.Backtrack.l79WordSearch;
import java.util.*;
public class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(board[i][j] == word.charAt(0)) list.add(new int[]{i, j});
            }
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int[] arr: list) {
            if(dfs(board, visited, arr[0], arr[1], 0, word)) return true;
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, int curIndex, String word) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return false;
        }

        if(board[x][y] != word.charAt(curIndex)) return false;

        curIndex++;
        if(curIndex == word.length()) return true;
        visited[x][y] = true;

        for(int[] dir: dirs) {
            if(dfs(board, visited, x + dir[0], y + dir[1], curIndex, word)) return true;
        }

        visited[x][y] = false;
        return false;
    }
}