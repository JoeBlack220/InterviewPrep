package topics.Design.l211AddandSearchWord;

public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int index, TrieNode cur) {
        if(index == word.length()) return cur.isEnd;
        if(word.charAt(index) == '.') {
            for(TrieNode child: cur.children) {
                if(child != null) {
                    if(searchHelper(word, index + 1, child)) return true;
                }
            }
            return false;
        }
        else {
            if(cur.children[word.charAt(index) - 'a'] == null) return false;
            else return searchHelper(word, index + 1, cur.children[word.charAt(index) - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
