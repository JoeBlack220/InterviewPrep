package cc189.chapter1;

public class IsUnique {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUnique2("abcdefgg"));
    }
    static class Solution {
        // space O(128) time O(n)
        public boolean isUnique1(String s) {
            boolean[] dict = new boolean[128];
            for(char c: s.toCharArray()) {
                if(dict[c]) return false;
                else dict[c] = true;
            }
            return true;
        }
        // space O(1) time O(n)
        public boolean isUnique2(String s) {
            int val = 0;
            for(char c: s.toCharArray()) {
                int index = c - 'a';
                if((val & (1 << index)) > 0) return false;
                val |= (1 << index);
            }
            return true;
        }

    }

}
