package leetcode.HashTable.l249GroupShiftedStrings;
import java.util.*;
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s : strings) {
            StringBuilder sb = new StringBuilder();
            char first = s.charAt(0);
            for(int i = 1; i < s.length(); ++i) {
                sb.append((26 - s.charAt(i) + first) % 26);
                sb.append(",");
            }
            String sig = sb.toString();
            if(map.containsKey(sig)) {
                res.get(map.get(sig)).add(s);
            }
            else {
                map.put(sig, res.size());
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(s);
            }
        }
        return res;
    }
}
