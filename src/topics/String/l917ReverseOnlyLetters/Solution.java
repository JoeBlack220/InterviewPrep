package topics.String.l917ReverseOnlyLetters;
import java.util.*;
public class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        List<Integer> q1 = new LinkedList<>();
        List<Character> q2 = new LinkedList<>();

        for(int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if(Character.isLetter(c)) {
                sb.append(c);
            }
            else {
                q1.add(i);
                q2.add(c);
            }
        }

        sb = sb.reverse();
        int curIndex = 0;
        for(int i = 0; i < S.length(); ++i) {
            if(curIndex < q1.size()) {
                if(q1.get(curIndex) == i) {
                    char c = q2.get(curIndex);
                    sb.insert(i, c);
                    curIndex++;
                }
            }
            else break;
        }

        return sb.toString();

    }
}