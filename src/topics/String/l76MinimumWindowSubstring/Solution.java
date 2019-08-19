package topics.String.l76MinimumWindowSubstring;
import java.util.*;
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        int start = 0, end = 0, len = s.length();
        int zeroes = 0;
        String res = "";

        while(end < len) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) zeroes++;
            }

            while(zeroes == map.size()) {
                char before = s.charAt(start);
                if(end - start < min) {
                    min = end - start;
                    res = s.substring(start, end + 1);
                }
                if(map.containsKey(before)) {
                    map.put(before, map.get(before) + 1);
                    if(map.get(before) == 1) {
                        zeroes--;
                    }
                }
                start++;
            }
            end++;
        }
        return res;

    }
}
