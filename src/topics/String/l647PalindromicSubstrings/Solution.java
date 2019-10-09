package topics.String.l647PalindromicSubstrings;
// solution1 dp
public class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), count = 0;
        boolean[][] dp = new boolean[len][len];

        for(int l = 1; l <= len; l++) {
            for(int i = 0; i <= len - l; ++i) {
                int j = i + l - 1;
                if(l == 1) {
                    count++;
                    dp[i][j] = true;
                }
                else {
                    if(s.charAt(i) == s.charAt(j) && (l == 2 || dp[i + 1][j-1])) {
                        count++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return count;

    }
}

// solution2, extend palindrome at all indexes
class Solution2 {
    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}