package leetcode.String.l1071GreatestCommonDivisorofStrings;

public class Solution {
    // ugly solution use many flags
    public String gcdOfStrings1(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        String prev = "";
        for(int i = len2; i >= 1; --i) {
            if(len1 % i != 0 || len2 % i != 0) continue;
            String cur = str2.substring(0, i);
            boolean flag1 = false, flag2 = false;
            for(int j = 0; j < len1 / i; ++j) {
                if(!cur.equals(str1.substring(j * i, (j + 1) * i))) {
                    flag1 = true;
                    break;
                }
            }
            for(int j = 0; !flag1 && j < len2 / i; ++j) {
                if(!cur.equals(str2.substring(j * i, (j + 1) * i))) {
                    flag2 = true;
                    break;
                }
            }
            if(flag1 || flag2) continue;
            return cur;
        }
        return "";
    }
    // gcd solution
//    Time & space: O(n ^ 2), where n = max(str1.length(), str2.length())
    public String gcdOfStrings2(String str1, String str2) {
        if (str1.length() < str2.length()) { return gcdOfStrings2(str2, str1); } // make sure str1 is not shorter than str2.
        else if (!str1.startsWith(str2)) { return ""; } // shorter string is not common prefix.
        else if (str2.isEmpty()) { return str1; } // gcd string found.
        else { return gcdOfStrings2(str1.substring(str2.length()), str2); } // cut off the common prefix part of str1.
    }
}