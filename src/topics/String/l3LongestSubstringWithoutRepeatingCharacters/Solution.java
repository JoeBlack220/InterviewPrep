package topics.String.l3LongestSubstringWithoutRepeatingCharacters;
import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int pointer = 0, res = 0;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                int limit = map.get(c);
                while(pointer <= limit) {
                    map.remove(s.charAt(pointer++));
                }
                map.put(c, i);
            }
            else {
                map.put(c, i);
            }
            res = Math.max(i - pointer + 1, res);
        }
        return res;
    }
}
