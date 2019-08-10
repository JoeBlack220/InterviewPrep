package topics.Backtrack.l17LetterCombinationsofaPhoneNumber;
import java.util.*;
public class Solution {
    char[][] map = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits.length() == 0) {
            return res;
        }
        helper(digits, "", res);
        return res;
    }

    private void helper(String res, String cur, List<String> list) {
        if(res.length() == 0) list.add(cur);
        else {
            String next = res.substring(1);
            for(char c: map[res.charAt(0) - '2']) {
                helper(next, cur + c, list);
            }
        }
    }
}