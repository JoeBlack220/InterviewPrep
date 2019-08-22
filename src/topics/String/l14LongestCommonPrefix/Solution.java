package topics.String.l14LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);
            boolean flag = false;
            for(int j = 1; j < strs.length; ++j) {
                if(strs[j].length() <= i || strs[j].charAt(i) != c) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
            else sb.append(c);
        }
        return sb.toString();
    }
}
