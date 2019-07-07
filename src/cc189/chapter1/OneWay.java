package cc189.chapter1;

public class OneWay {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.check("pale", "palss"));
    }
    // space O(1) time O(n)
    static class Solution {
        public boolean check(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            if(len1 < len2) return check(s2, s1);
            if(len1 - len2 > 1) return false;
            int i = 0, j = 0;
            boolean flag = false;
            while(i < len1 && j < len2) {
                if(s1.charAt(i) != s2.charAt(j)) {
                    if(flag == true) return false;
                    flag = true;
                    if(i == j) {
                        j++;
                    }
                } else {
                    j++;
                }
                i++;
            }
            return i == len1;
        }
    }
}
