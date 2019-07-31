package leetcode.Trie.l676ImplementMagicDictionary;

public class MagicDictionary {
    // Trie solution
    // space O(26^max(length)) time(O(26^max(length))
    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict) {
            Trie cur = root;
            for(char c: s.toCharArray()) {
                if(cur.get(c) == null) cur.addChildren(c);
                cur = cur.get(c);
            }
            cur.isEnd = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    private boolean searchHelper(String word, Trie cur, int count) {
        if(count >= 2) return false;
        if(word.length() == 0) return (count == 1 && cur.isEnd);
        char c = word.charAt(0);
        if(cur.get(c) == null) {
            for(Trie t: cur.children) {
                if(t != null && searchHelper(word.substring(1), t, count + 1)) return true;
            }
            return false;
        }
        else {
            for(int i = 0; i < 26; i++) {
                Trie t = cur.children[i];
                boolean flag = (c - 'a') == i;
                if(t != null && !flag && searchHelper(word.substring(1), t, count + 1)) return true;
                else if(t != null && flag && searchHelper(word.substring(1), t, count)) return true;
            }
            return false;
        }

    }

    class Trie {
        private Trie[] children;
        private boolean isEnd;
        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
        public Trie get(char c) {
            return children[c - 'a'];
        }
        public void addChildren(char c) {
            children[c - 'a'] = new Trie();
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */