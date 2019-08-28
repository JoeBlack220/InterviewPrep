package topics.String.l422ValidWordSquare;
import java.util.*;
public class Solution {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); ++i) {
            String cur = words.get(i);
            for(int j = 0; j < cur.length(); ++j) {
                if(words.size() <= j || words.get(j).length() <= i
                        || cur.charAt(j) != words.get(j).charAt(i)) return false;
            }
        }
        return true;
    }
}