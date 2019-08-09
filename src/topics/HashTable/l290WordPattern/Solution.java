package topics.HashTable.l290WordPattern;
import java.util.*;
public class Solution {
    // we can use two hash map to check if the pattern and str match in both directions
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<Character, String> map_p_to_s = new HashMap<>();
        Map<String, Character> map_s_to_p = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String cur = strs[i];
            boolean flag1 = map_p_to_s.containsKey(c), flag2 = map_s_to_p.containsKey(cur);
            if(!flag1 && !flag2) {
                map_p_to_s.put(c, cur);
                map_s_to_p.put(cur, c);
            }
            else if(flag1 && flag2) {
                if(!map_p_to_s.get(c).equals(cur) || map_s_to_p.get(cur) != c) return false;
            }
            else return false;
        }
        return true;
    }
    // we can also just using one hash map to achieve that
    // we don't specify type to the hash map, so both directions matching can be fit into the hash map

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
