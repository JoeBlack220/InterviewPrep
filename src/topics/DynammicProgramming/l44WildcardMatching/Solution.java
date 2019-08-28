package topics.DynammicProgramming.l44WildcardMatching;

public class Solution {
    // backtrack solution
    // got TLE..
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int s1, int p1) {
        while(p1 < p.length()) {
            if(p.charAt(p1) == '*') {
                for(int i = s1; i <= s.length(); ++i) {
                    if(helper(s, p, i, p1 + 1)) return true;
                }
                return false;
            }
            else if(s1 >= s.length()) break;
            else if(!matches(s.charAt(s1++), p.charAt(p1++))) return false;
        }
        if(s1 == s.length() && p1 == p.length()) return true;
        else return false;
    }

    private boolean matches(char c1, char c2) {
        if(c1 == c2) return true;
        else if(c2 == '?' || c1 == '?') return true;
        else return false;
    }
}
// two pointers solution
// time O(MN) space O(1)
class Solution2 {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
// dp solution
// time O(mn) space O(mn)
class Solution3 {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for(int i = 1; i <= plen; ++i) {
            if(p.charAt(i - 1) == '*' && dp[0][i - 1]) dp[0][i] = true;
        }

        for(int i = 1; i <= slen; ++i) {
            for(int j = 1; j <= plen; ++j) {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*') dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1]);
            }
        }
        return dp[slen][plen];
    }
}