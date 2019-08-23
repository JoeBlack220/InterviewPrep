package topics.HashTable.l242ValidAnagram;
import java.util.*;
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] dict = new int[26];
        for(char c: s.toCharArray()) dict[c - 'a'] ++;
        for(char c: t.toCharArray()) {
            dict[c - 'a'] --;
            if(dict[c - 'a'] < 0) return false;
        }
        return true;
    }
}

class Solution2 {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }
}