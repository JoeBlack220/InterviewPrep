package topics.Trie.l212WordSearchII;
import java.util.*;
public class Solution {
    private int m;
    private int n;
    private Trie trie;
    private Set<String> res;
    private char[][] board;
    private int[][] dirs =  new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        trie = new Trie(words);
        this.board = board;
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                dfs(i, j, trie.root, new HashSet<>());
            }
        }

        List<String> list = new ArrayList<>();
        list.addAll(res);
        return list;
    }

    private void dfs(int x, int y, TrieNode last, Set<String> visited) {
        if(x < 0 || x >= m || y < 0 || y >= n || last.getChild(board[x][y]) == null) return;
        String sig = x + "," + y;
        if(!visited.add(sig)) return;
        last = last.getChild(board[x][y]);
        if(last.s != null) res.add(last.s);
        visited.add(sig);
        for(int[] dir: dirs) {
            dfs(x + dir[0], y + dir[1], last, visited);
        }
        visited.remove(sig);
    }

    class Trie {
        TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for(String word: words) {
                TrieNode cur = root;
                for(char c: word.toCharArray()) {
                    if(cur.getChild(c) == null) cur.setChild(c);
                    cur = cur.getChild(c);
                }
                cur.s = word;
            }
        }
    }

    class TrieNode {
        TrieNode[] children;
        String s;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public void setChild(char c) {
            children[c - 'a'] = new TrieNode();
        }
    }

}