package topics.String.l186ReverseWordsinaStringII;

public class Solution {
    public void reverseWords(char[] s) {
        int len = s.length;
        int pointer = 0;
        for(int i = 0; i < len; ++i) {
            if(s[i] == ' ') {
                reverse(s, pointer, i - 1);
                pointer = i + 1;
            }
            if(i == len - 1) reverse(s, pointer, i);
        }
        reverse(s, 0, len - 1);
    }

    private void reverse(char[] s, int l, int r) {
        while(l < r) {
            exch(s, l++, r--);
        }
    }

    private void exch(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}