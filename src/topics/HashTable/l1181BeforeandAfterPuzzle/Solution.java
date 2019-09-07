package topics.HashTable.l1181BeforeandAfterPuzzle;
import java.util.*;
public class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> res = new HashSet<>();
        Set<String> dict = new HashSet<>();
        for(String p : phrases) {
            String[] cur = p.split(" ");
            if(cur.length == 1) {
                if(dict.contains(p)) res.add(p);
            }
            dict.add(p);
            if(!map.containsKey(cur[cur.length - 1])) {
                map.put(cur[cur.length - 1], new HashSet<>());
            }

            map.get(cur[cur.length - 1]).add(p);
        }
        for(String p: phrases) {
            String[] cur = p.split(" ");
            // System.out.println(cur[0]);
            if(map.containsKey(cur[0])) {
                Set<String> set = map.get(cur[0]);
                for(String prefix : set) {
                    if(prefix.equals(p)) continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(prefix);
                    String toAppend = p.indexOf(" ") == -1 ? "" : p.substring(p.indexOf(" "));
                    sb.append(toAppend);
                    res.add(sb.toString());
                }
            }
        }
        List<String> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }
}
