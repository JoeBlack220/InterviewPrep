package leetcode.String.l28ImplementstrStr;

public class Solution {
    // kmp version
    // time O(n) space O(m)
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int[] lps = generateLPSArray(needle);
        int i = 0, j = 0;
        while(i < l1) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if(j == l2) return i - j;

            else if(i < l1 && haystack.charAt(i) != needle.charAt(j)) {
                if(j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i ++;
                }
            }
        }
        return -1;
    }
    private int[] generateLPSArray(String pat) {
        int len = pat.length();
        int[] lps = new int[len];
        int i = 1;
        int preLen = 0;
        while(i < len) {
            if(pat.charAt(preLen) == pat.charAt(i)) {
                preLen ++;
                lps[i++] = preLen;
            }
            else {
                if(preLen != 0) {
                    preLen = lps[preLen - 1];
                }
                else {
                    lps[i] = preLen;
                    i++;
                }
            }
        }
        return lps;
    }
}
