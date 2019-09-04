package topics.String.l161OneEditDistance;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen < tLen) return isOneEditDistance(t, s);
        boolean flag = sLen == tLen;

        for(int i = 0; i < tLen; ++i) {
            if(s.charAt(i) != t.charAt(i)) {
                if(flag) {
                    return s.equals(t.substring(0, i) + s.charAt(i) + t.substring(i + 1));
                }
                else {
                    return s.equals(t.substring(0, i) + s.charAt(i) + t.substring(i));
                }
            }
        }
        return tLen == sLen - 1;
    }
}
