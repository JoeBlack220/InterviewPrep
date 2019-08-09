package topics.Trie.l421MaximumXORofTwoNumbersInanArray;

public class Solution {
    // O(n) but actually very slow
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        TrieNode root = new TrieNode();
        for(int num: nums) {
            int value = 0;
            String s = String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0');
            char[] arr = s.toCharArray();
            TrieNode cur = root;
            for(char c: arr) {
                if(cur.children[(c - '0')] == null) cur.children[(c - '0')] = new TrieNode();
                cur = cur.children[(c - '0')];
            }
            cur = root;
            for(char c: arr) {
                if(cur.children[(c - '0') ^ 1] != null) {
                    value <<= 1;
                    value += 1;
                    cur = cur.children[(c - '0') ^ 1];
                }
                else {
                    value <<= 1;
                    cur = cur.children[(c - '0')];
                }
            }
            res = Math.max(res, value);
        }
        return res;
    }
    class TrieNode{
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }
}
