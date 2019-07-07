package cc189.chapter1;

public class IsUnique {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUnique1("abcdefg"));
        System.out.println(sol.isUnique2("abcdefg"));
        System.out.println(sol.isUnique3("abcdefg"));
    }
    static class Solution {
        // space O(128) time O(n)
        public boolean isUnique1(String s) {
            if(s.length() > 128) return false;
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
        // space O(1) time O(n^2)
        public boolean isUnique3(String s) {
            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                for(int j = i + 1; j < s.length(); ++j) {
                    if(c == s.charAt(j)) return false;
                }
            }
            return true;
        }

        // if we are allowed to change to input array, we can first sort it than compare each character in O(n) time.

    }

}
