package topics.Trie.l425WordSquares;
import java.util.*;
public class Solution {
    TrieNode root;
    public List<List<String>> wordSquares(String[] words) {
        root = new TrieNode();
        List<List<String>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        buildTrie(words);
        int len = words[0].length();
        for(String word: words) {
            List<String> cur = new LinkedList<>();
            cur.add(word);
            search(res, cur, len);
        }
        return res;
    }

    private void search(List<List<String>> res, List<String> cur, int len) {
        if(cur.size() == len) {
            List<String> toAdd = new LinkedList<>();
            toAdd.addAll(cur);
            res.add(toAdd);
            return;
        }
        TrieNode current = root;
        int size = cur.size();
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < size; ++i) {
            char c = cur.get(i).charAt(size);
            // System.out.println(c);
            if(current.getChild(c) == null) return;
            else {
                prefix.append(c);
                current = current.getChild(c);
            }
        }
        List<String> suffix = current.allPossible();
        String prefixS = prefix.toString();
        if(suffix.size() == 0) return;
        else {
            for(String s: suffix) {
                cur.add(prefix + s);
                search(res, cur, len);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private void buildTrie(String[] words) {
        for(String word: words) {
            TrieNode cur = root;
            for(char c: word.toCharArray()) {
                if(cur.getChild(c) == null) cur.setChild(c);
                cur = cur.getChild(c);
            }
            cur.isEnd = true;
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }

        private TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        private void setChild(char c) {
            children[c - 'a'] = new TrieNode();
        }

        private List<String> allPossible() {
            List<String> res = new ArrayList<>();
            if(isEnd) {
                res.add("");
                return res;
            }
            for(char c = 'a'; c <= 'z'; ++c) {
                if(getChild(c) != null) {
                    List<String> child = getChild(c).allPossible();
                    for(String s: child) {
                        res.add(c + s);
                    }
                }
            }
            return res;
        }
    }

}