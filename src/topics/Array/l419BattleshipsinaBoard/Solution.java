package topics.Array.l419BattleshipsinaBoard;
// only count the top-left X
// O(n)
public class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return 0;
        int count = 0;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(board[i][j] == '.') continue;
                if(i != 0 && board[i - 1][j] == 'X') continue;
                if(j != 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        return count;
    }
}