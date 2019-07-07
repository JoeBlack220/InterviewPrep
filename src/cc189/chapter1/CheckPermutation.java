package cc189.chapter1;
import java.util.Arrays;
public class CheckPermutation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.check1("abcade", "cdbaae"));
        System.out.println(sol.check2("bbbccc", "cbbdcc"));
    }

    static class Solution{

        // space O(26) time O(n) we assume that no null input and all strings contain only lower case letter.
        // if the character set is ASCII we should use a dict with 128 length
        // then the space complexity should be O(128)
        public boolean check1(String s1, String s2){
            int len1 = s1.length(), len2 = s2.length();
            if(len1 != len2) return false;
            int[] dict = new int[26];
            for(char c: s1.toCharArray()) {
                dict[c - 'a']++;
            }
            for(char c: s2.toCharArray()) {
                dict[c - 'a']--;
                if(dict[c - 'a'] < 0) return false;
            }
            return true;
        }

        // space O(n) time O(n)
        public boolean check2(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if(len1 != len2) return false;
            return sort(s1).equals(sort(s2));
        }

        private String sort(String s1) {
            char[] temp = s1.toCharArray();
            Arrays.sort(temp);
            return new String(temp);
        }

    }
}
