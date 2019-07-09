package leetcode.String.l925LongPressedName;

public class Solution {

    // space O(1) time O(n) beats 55.4%
    public boolean isLongPressedName(String name, String typed) {
        int pointer1 = 0, pointer2 = 0;
        int len1 = name.length(), len2 = typed.length();
        while(pointer1 < len1 && pointer2 < len2) {
            if(name.charAt(pointer1) != typed.charAt(pointer2)) return false;
            int counter1 = 1, counter2 = 1;
            while(pointer1 + counter1 < len1 && name.charAt(pointer1 + counter1) == name.charAt(pointer1))
                counter1++;
            while(pointer2 + counter2 < len2 && typed.charAt(pointer2 + counter2) == typed.charAt(pointer2))
                counter2++;
            if(counter1 > counter2) return false;
            pointer1 += counter1;
            pointer2 += counter2;
        }
        return pointer1 == len1 && pointer2 == len2;
    }
    // a more concise version beats 100%
    public boolean isLongPressedName1(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j)
            if (i < m && name.charAt(i) == typed.charAt(j))
                ++i;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        return i == m;
    }
}