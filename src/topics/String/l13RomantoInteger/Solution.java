package topics.String.l13RomantoInteger;
import java.util.*;
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> dict = buildMap();
        int smallest = Integer.MAX_VALUE;
        int res = 0;
        for(char c: s.toCharArray()) {
            int cur = dict.get(c);
            res += cur;
            if(cur > smallest) res -= 2 * smallest;
            else smallest = cur;
        }
        return res;
    }

    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000
    private Map<Character, Integer> buildMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
