package topics.String.l5LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        String res = s.substring(0, 1);
        for(int i = 1; i < s.length(); ++i) {
            String s1 = helper(s, i - 1, i);
            if(s1.length() > res.length()) res = s1;
            String s2 = helper(s, i, i);
            if(s2.length() > res.length()) res = s2;
        }
        return res;
    }

    private String helper(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

}