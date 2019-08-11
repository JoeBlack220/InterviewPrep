package topics.String.l1156SwapForLongestRepeatedCharacterSubstring;
import java.util.*;
public class Solution {
    public int maxRepOpt1(String text) {
        TreeMap<Integer, Integer>[] dict = new TreeMap[26];
        for(int i = 0; i < 26; ++i) dict[i] = new TreeMap<>();
        int len = text.length();
        if(len == 0) return 0;
        int start = 0;
        char last = text.charAt(0);
        for(int i = 1; i < len; ++i) {
            if(text.charAt(i) != last) {
                dict[last - 'a'].put(start, i - 1);
                start = i;
                last = text.charAt(i);
            }
        }
        dict[last - 'a'].put(start, len - 1);

        int max = 0;
        for(TreeMap<Integer, Integer> map: dict) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(0);
            while(entry != null) {
                // System.out.println(entry.getKey() + ","+ entry.getValue());
                Map.Entry<Integer, Integer> next = map.ceilingEntry(entry.getValue() + 1);
                if(next == null && map.floorEntry(entry.getKey() - 1) == null) {
                    max = Math.max(max, entry.getValue() - entry.getKey() + 1);
                }
                else if((next == null && !(map.floorEntry(entry.getKey() - 1) == null)) || next.getKey() != entry.getValue() + 2) {
                    max = Math.max(max, entry.getValue() - entry.getKey() + 2);
                }
                else{
                    if(map.ceilingEntry(next.getKey() + 1) != null || map.floorEntry(entry.getKey() - 1) != null) {
                        max = Math.max(max, next.getValue() - entry.getKey() + 1);
                    }
                    else max = Math.max(max, next.getValue() - entry.getKey());
                }
                entry = next;
            }
        }
        return max;
    }
}
