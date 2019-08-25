package topics.String.l49GroupAnagrams;
import java.util.*;
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] cur = s.toCharArray();
            Arrays.sort(cur);
            String sig = new String(cur);
            if(map.containsKey(sig)) map.get(sig).add(s);
            else {
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(sig, list);
            }
        }
        List<List<String>> res = new LinkedList<>(map.values());
        return res;
    }
}
