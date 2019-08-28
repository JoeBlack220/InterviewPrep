package topics.String.l395LongestSubstringwithAtLeastKRepeatingCharacters;

public class Solution {
    // we try to use two pointer to tackle this question
    // but it's hard to decide when to move the start pointer
    // so we can add constraints, every time we only try to find
    // substring with n unique characters that meets the conditions
    // time O(26n) space O(n)
    public int longestSubstring(String s, int k) {
        int res = 0;
        for(int i = 1; i <= 26; ++i) {
            res = Math.max(findNUnique(s, k, i), res);
        }
        return res;
    }

    private int findNUnique(String s, int k, int n) {
        int[] dict = new int[26];
        int start = 0, end = 0;
        int total = 0, qualified = 0;
        int res = 0;
        while(end < s.length()) {
            char c1 = s.charAt(end++);
            if(dict[c1 - 'a']++ == 0) total++;
            if(dict[c1 - 'a'] == k) qualified++;
            while(total > n) {
                char c2 = s.charAt(start++);
                if(dict[c2 - 'a']-- == k) qualified--;
                if(dict[c2 - 'a'] == 0) total--;
            }
            if(qualified == n && qualified == total) res = Math.max(res, end - start);
        }
        return res;
    }
}