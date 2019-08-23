package topics.Math.l247StrobogrammaticNumberII;
import java.util.*;
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        List<String> lastTwo = new ArrayList<>();
        List<String> lastOne = new ArrayList<>();
        List<String> current = new ArrayList<>();
        lastTwo.add("");
        lastOne.add("0");
        lastOne.add("1");
        lastOne.add("8");

        if(n == 0) return new ArrayList<>();
        if(n == 1) return lastOne;

        for(int i = 2; i <= n; i++) {
            for(String s: lastTwo) {
                for(Map.Entry<Character, Character> entry: map.entrySet()) {
                    if(i == n && entry.getValue() == '0') continue;
                    else current.add(entry.getKey() + s + entry.getValue());
                }
            }
            lastTwo = lastOne;
            lastOne = current;
            current = new ArrayList<>();
        }
        return lastOne;
    }
}
