package topics.String.l848ShiftingLetters;

public class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int len = shifts.length;
        int[] suffix = new int[len];
        for(int i = len - 1; i >= 0; --i) {
            if(i == len - 1) suffix[i] = shifts[i] % 26;
            else {
                suffix[i] = (suffix[i + 1] + shifts[i] % 26 ) % 26;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < S.length(); ++i) {
            char toAppend = (char) ((S.charAt(i) - 'a' + suffix[i]) % 26 + 'a');
            sb.append(toAppend);
        }

        return sb.toString();
    }
}
