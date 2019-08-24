package topics.Design.l642DesignSearchAutocompleteSystem;
import java.util.*;
// beware that when two sentences have the same freq, return the one with the
// smaller lexical order
public class AutocompleteSystem {
    class TrieNode {
        TrieNode[] children;
        Pair info;

        public TrieNode() {
            children = new TrieNode[27];
        }

        public TrieNode getChild(char c) {
            if(c == ' ') return children[26];
            else return children[c - 'a'];
        }

        public void setChild(char c) {
            if(c == ' ') children[26] = new TrieNode();
            else children[c - 'a'] = new TrieNode();
        }
    }
    class Pair {
        String s;
        int freq;
        public Pair(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }
    }

    private TrieNode root;
    private TrieNode cur;
    private StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        int len = sentences.length;
        sb = new StringBuilder();
        for(int i = 0; i < len; ++i) {
            TrieNode current = root;
            for(char c: sentences[i].toCharArray()) {
                if(current.getChild(c) == null) current.setChild(c);
                current = current.getChild(c);
            }
            current.info = new Pair(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.freq == b.freq) return a.s.compareTo(b.s);
            else return (b.freq - a.freq);
        });
        List<String> res = new ArrayList<>();
        if(c == '#') {
            if(cur.info == null) {
                cur.info = new Pair(sb.toString(), 1);
            }
            else {
                cur.info.freq++;
            }
            sb = new StringBuilder();
            cur = root;
            return res;
        }
        else {
            sb.append(c);
            if(cur.getChild(c) == null) {
                cur.setChild(c);
                cur = cur.getChild(c);
                return res;
            }
            else {
                cur = cur.getChild(c);
                dfs(cur, pq);
                while(!pq.isEmpty() && res.size() < 3) res.add(pq.poll().s);
                return res;
            }
        }
    }

    private void dfs(TrieNode cur, PriorityQueue<Pair> pq) {
        if(cur.info != null) pq.offer(cur.info);
        for(TrieNode child: cur.children) {
            if(child != null) dfs(child, pq);
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */