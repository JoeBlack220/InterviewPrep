package topics.Array.l344ReverseString;

public class Solution {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length / 2; ++i) {
            exch(s, i, s.length - 1 - i);
        }
    }

    private void exch(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}