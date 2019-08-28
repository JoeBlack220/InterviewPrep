package topics.Trie.l1032StreamofCharacters;
// reversely build the trie
public class StreamChecker {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();
    int max = 0;
    private void buildTrie(String[] words) {
        for(String s: words) {
            TrieNode cur = root;
            max = Math.max(s.length(), max);
            for(int i = s.length() - 1; i >= 0; --i) {
                char c = s.charAt(i);
                if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }
    }

    public StreamChecker(String[] words) {
        buildTrie(words);
    }

    public boolean query(char letter) {
        sb.append(letter);
        while(sb.length() != 0 && sb.length() > max) sb.deleteCharAt(0);
        TrieNode cur = root;
        for(int i = sb.length() - 1; i >= 0; --i) {
            cur = cur.children[sb.charAt(i) - 'a'];
            if(cur == null) return false;
            if(cur.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */