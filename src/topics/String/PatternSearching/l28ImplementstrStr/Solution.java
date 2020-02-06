package topics.String.PatternSearching.l28ImplementstrStr;
// solution 1 KMP
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        int[] lps = computeLPSArray(needle);
        int i = 0, j = 0, N = haystack.length(), M = needle.length();

        while(i < N) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if(j == M) return i - j;
            else if(i < N && needle.charAt(j) != haystack.charAt(i)) {
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;

    }

    private int[] computeLPSArray(String pattern) {
        // i, the current pointer, curLen, longest prefix's length that equal to the suffix
        int i = 1, curLen = 0, len = pattern.length();
        int[] lps = new int[len];
        while(i < len) {
            if(pattern.charAt(i) == pattern.charAt(curLen)) {
                lps[i++] = ++curLen;
            }
            else {
                // if curLen == 0, then the longest suffix equals to the prefix is of length 0
                if(curLen == 0) {
                    lps[i++] = curLen;
                }
                else {
                    curLen = lps[curLen - 1];
                }
            }
        }
        return lps;
    }
}

// solution 2 built-in
class Solution2 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// solution 3 brute force
class Solution3 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0 || haystack.equals(needle)) return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            if(bruteForce(haystack, i, needle)) return i;
        }
        return -1;
    }

    private boolean bruteForce(String s, int start, String pattern) {
        int i = start, j = 0;
        while(j < pattern.length()) {
            if(s.charAt(i++) != pattern.charAt(j++)) return false;
        }
        return true;
    }
}

// solution 4 rabin karp
class Solution4 {
    final int d = 256;
    final int q = 101;
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        int i, M = needle.length(), N = haystack.length();
        int sh = 0, ph = 0;
        // h is the wight that the first character in the current substring of s has
        int h = 1;
        // compute h -> pow(d, M - 1) % q
        for(i = 0; i < M - 1; ++i) h = (d * h) % q;
        // compute the hash value of the pattern and the first window of s
        for(i = 0; i < M; ++i) {
            sh = (haystack.charAt(i) + sh * d) % q;
            ph = (needle.charAt(i) + ph * d) % q;
        }

        for(i = 0; i < N - M + 1; ++i) {
            if (sh == ph) {
                if (bruteForce(haystack, i, needle)) return i;
            }
            // System.out.println(sh + "<" + ph);
            if(i < N - M)
                sh = ((d * (sh - h * haystack.charAt(i))) % q + haystack.charAt(i + M) + q) % q;
        }
        return -1;
    }

    private boolean bruteForce(String s, int index, String p) {
        int i = index, j = 0;
        while(j < p.length()) {
            if(s.charAt(i++) != p.charAt(j++)) return false;
        }
        return true;
    }
}

// solution 5, build a dfa using kmp
// time O(d * m + n) d is the size of the character set
// space O(d * m)
class Solution5 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        int M = needle.length(), N = haystack.length();
        int[][] dfa = buildDFA(needle);
        int j = 0, i;
        for(i = 0; i < N && j < M; ++i) {
            j = dfa[haystack.charAt(i)][j];
        }
        if(j == M) return i - M;
        else return -1;
    }

    private int[][] buildDFA(String needle) {
        int M = needle.length();
        int[][] dfa = new int[128][M];

        dfa[needle.charAt(0)][0] = 1;
        for(int j = 1, X = 0; j < M; ++j) {
            for(int i = 0; i <= 127; ++i) {
                dfa[i][j] = dfa[i][X];
            }
            dfa[needle.charAt(j)][j] = j + 1;
            X = dfa[needle.charAt(j)][X];
        }

        return dfa;
    }
}