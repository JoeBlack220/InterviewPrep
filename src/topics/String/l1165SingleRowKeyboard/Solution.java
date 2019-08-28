package topics.String.l1165SingleRowKeyboard;

public class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] dict = new int[26];
        for(int i = 0; i < keyboard.length(); ++i) {
            dict[keyboard.charAt(i) - 'a'] = i;
        }
        int res = 0, last = 0;
        for(char c: word.toCharArray()) {
            res += Math.abs(last - dict[c - 'a']);
            last = dict[c - 'a'];
        }
        return res;
    }
}
