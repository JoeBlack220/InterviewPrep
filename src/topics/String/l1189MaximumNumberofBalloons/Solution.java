package topics.String.l1189MaximumNumberofBalloons;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] dict = new int[26];
        for(char c: text.toCharArray()) {
            dict[c - 'a'] ++;
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, dict['b' - 'a']);
        res = Math.min(res, dict['a' - 'a']);
        res = Math.min(res, dict['l' - 'a'] / 2);
        res = Math.min(res, dict['n' - 'a']);
        res = Math.min(res, dict['o' - 'a'] / 2);
        return res;
    }
}
