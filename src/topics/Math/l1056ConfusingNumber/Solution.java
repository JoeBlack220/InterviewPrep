package topics.Math.l1056ConfusingNumber;
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public boolean confusingNumber(int N) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0'); map.put('1', '1'); map.put('6', '9'); map.put('8', '8'); map.put('9', '6');
        String num = Integer.toString(N);
        int len = num.length();
        boolean flag = false;
        for(int i = 0; i < (len + 1) / 2; ++i) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(len - 1 - i);
            if(!map.containsKey(c1) || !map.containsKey(c2)) return false;
            if(map.get(c1) != c2) flag = true;
        }
        return flag;
    }
}
