package topics.Trie.l411MinimumUniqueWordAbbreviation;
import java.util.*;
public class Solution {

    private class TrieNode{
        String word;
        TrieNode[] next = new TrieNode[26];
    }

    public String minAbbreviation(String target, String[] dictionary) {
        if (target == null || target.equals("")) return target;
        if (dictionary == null || dictionary.length == 0) return target.length() + "";
        int m = target.length();

        TrieNode root = new TrieNode();
        buildTrie(root, dictionary, m);

        List<String> abbr = new ArrayList<>();
        addAbbr(target, new String(), 0, 0, abbr);
        Collections.sort(abbr, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        for (String s : abbr) {
            if (!findMatch(s, root, 0, 0)) return s;
        }
        return "";
    }

    private boolean findMatch(String s, TrieNode node, int pos, int cnt) {
        int n = s.length();
        if (node == null) return false;
        if (cnt != 0) {
            for (int i = 0; i < 26; i++) {
                if (findMatch(s, node.next[i], pos, cnt - 1)) return true;
            }
            return false;
        }
        if (pos == n) {
            if (node.word != null) return true;
            return false;
        }
        int i = pos;
        while (i < n) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cnt = cnt * 10 + c - '0';
                i++;
            } else {
                break;
            }
        }
        if (cnt == 0) {
            char c = s.charAt(i);
            return findMatch(s, node.next[c - 'a'], i + 1, cnt);
        }
        return findMatch(s, node, i, cnt); //should be i not i + 1...
    }

    private void addAbbr(String s, String cur, int pos, int cnt, List<String> res) {
        int n = s.length();
        if (pos == n) {
            if (cnt != 0) {
                cur += cnt;
            }
            res.add(cur);
            return;
        }
        addAbbr(s, cur, pos + 1, cnt + 1, res);
        if (cnt != 0) {
            cur += cnt;
        }
        addAbbr(s, cur + s.charAt(pos), pos + 1, 0, res);
    }

    private void buildTrie(TrieNode root, String[] dict, int len) {
        for (String s : dict) {
            if (s.length() != len) continue;
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.word = s;
        }
    }
}
