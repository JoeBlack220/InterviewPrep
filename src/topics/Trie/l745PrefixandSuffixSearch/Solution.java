package topics.Trie.l745PrefixandSuffixSearch;

public class Solution {
    // solution 2 - trie
    // when add a word to trie, add all possible suffix in front of it
    // so when we query, we can query suffix_prefix to find whether a word is in the Trie or not
    Trie root;
    public Solution(String[] words) {
        root = new Trie();
        for(int i = 0; i < words.length; ++i) {
            String word = words[i];
            int len = word.length();
            for(int j = 0; j <= len; ++j) {
                // System.out.println((char)('z' + 1));
                String prePlusWord = word.substring(j, len) + "{" + word;
                Trie cur = root;
                for(char c: prePlusWord.toCharArray()) {
                    if(cur.getChild(c) == null) cur.setChild(c);
                    cur = cur.getChild(c);
                    cur.index = i;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        String sig = suffix + '{' + prefix;
        Trie cur = root;
        for(char c: sig.toCharArray()) {
            // System.out.println
            if(cur.getChild(c) == null) return -1;
            cur = cur.getChild(c);
        }
        return cur.index;
    }

    class Trie {
        Trie[] children;
        int index;
        public Trie() {
            children = new Trie[27];
        }

        public Trie getChild(char c) {
            return children[c - 'a'];
        }

        public void setChild(char c) {
            children[c - 'a'] = new Trie();
        }
    }
}
