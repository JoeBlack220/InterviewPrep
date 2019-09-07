package topics.String.l1180CountSubstringswithOnlyOneDistinctLetter;

public class Solution {
    public int countLetters(String S) {
        int start = 0, end = 0;
        int res = 0;
        char last = '0';
        while(end < S.length()) {
            if(S.charAt(end) != last) {
                start = end;
                last = S.charAt(end);
            }

            res += (end - start + 1);

            end++;
            // System.out.println(res);
        }

        return res;
    }
}
