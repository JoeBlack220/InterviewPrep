package topics.String.l387FirstUniqueCharacterinaString;

public class Solution {
    public int firstUniqChar(String s) {
        int[] dict = new int[26];
        int candidate = -1;
        for(char c: s.toCharArray()) {
            dict[c - 'a']++;
        }
        for(int i = 0; i < s.length(); ++i) {
            if(dict[s.charAt(i) - 'a'] == 1) {
                candidate = i;
                break;
            }
        }
        return candidate;
    }
}