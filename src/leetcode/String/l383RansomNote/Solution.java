package leetcode.String.l383RansomNote;

public class Solution {
    // construct an int array as the dict
    // space O(26) time O(n)
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];
        for(char c: ransomNote.toCharArray()) {
            dict[c - 'a']++;
        }
        for(char c: magazine.toCharArray()) {
            dict[c - 'a']--;
        }
        for(int num: dict) {
            if(num > 0) return false;
        }
        return true;
    }
    // examine the dict reversely
    // we can reduce one loop
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] table = new int[128];
        for (char c : magazine.toCharArray())   table[c]++;
        for (char c : ransomNote.toCharArray())
            if (--table[c] < 0) return false;
        return true;
    }
}
