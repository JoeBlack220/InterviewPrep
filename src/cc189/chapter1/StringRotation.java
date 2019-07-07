package cc189.chapter1;

public class StringRotation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isRotation("abcedfd", "edfabcs"));
    }

    static class Solution {
        public boolean isRotation(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if (len1 == len2) {
                String temp = s1 + s1;
                return isSubstring(temp, s2);
            }
            return false;
        }

        private boolean isSubstring(String s1, String s2) {
            // you can also use indexOf() here, if s1 doesn't contain s2
            // indexOf() will return -1
            return s1.contains(s2);
        }
        // similar to indexOf()
        // but use brute force space O(1) time O(mn)
        // could use kmp to do pattern matching O(m + n)
        private int isSubstring2(String s1, String s2)
        {
            int M = s1.length();
            int N = s2.length();

            /* A loop to slide pat[] one by one */
            for (int i = 0; i <= N - M; i++) {
                int j;

            /* For current index i, check for
            pattern match */
                for (j = 0; j < M; j++)
                    if (s2.charAt(i + j) != s1.charAt(j))
                        break;

                if (j == M)
                    return i;
            }

            return -1;
        }
    }
}
