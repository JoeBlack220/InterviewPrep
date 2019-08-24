package topics.HashTable.l205IsomorphicStrings;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] dict1 = new int[128], dict2 = new int[128];
        int len1 = s.length(), len2 = t.length();
        if(len1 != len2) return false;
        for(int i = 0; i < len1; ++i) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if(dict1[(int) c1] != dict2[(int) c2]) return false;
            dict1[(int) c1] += i + 1;
            dict2[(int) c2] += i + 1;
        }
        return true;
    }
}