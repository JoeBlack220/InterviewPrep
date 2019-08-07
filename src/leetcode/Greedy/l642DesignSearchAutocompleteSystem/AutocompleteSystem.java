package leetcode.Greedy.l642DesignSearchAutocompleteSystem;
import java.util.*;
public class AutocompleteSystem {
    Trie root;
    StringBuilder sb;
    Trie sofar;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        sb = new StringBuilder();
        sofar = root;
        for(int i = 0; i < sentences.length; ++i) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count) {
        Trie cur = root;
        cur.counts.put(s, cur.counts.getOrDefault(s, 0) + count);
        for(char c: s.toCharArray()) {
            if(cur.getChild(c) == null) cur.setChild(c);
            cur = cur.getChild(c);
            cur.counts.put(s, cur.counts.getOrDefault(s, 0) + count);
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            sofar = root;
            return new ArrayList<>();
        }
        sb.append(c);
        if(sofar.getChild(c) == null) {
            sofar.setChild(c);
            sofar = sofar.getChild(c);
            return new ArrayList<>();
        }
        sofar = sofar.getChild(c);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for(String s: sofar.counts.keySet()) {
            pq.offer(new Pair(s, sofar.counts.get(s)));
        }
        List<String> res = new ArrayList<>();
        while(res.size() < 3 && !pq.isEmpty()) {
            res.add(pq.poll().s);
        }
        return res;

    }

    class Pair{
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    class Trie{
        Trie[] children;
        Map<String, Integer> counts;
        public Trie() {
            children = new Trie[27];
            counts = new HashMap<>();
        }

        public Trie getChild(char c) {
            if(c == ' ') {
                return children[26];
            }
            else{
                return children[c - 'a'];
            }
        }

        public void setChild(char c) {
            if(c == ' ') {
                children[26] = new Trie();
            }
            else {
                children[c - 'a'] = new Trie();
            }
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
