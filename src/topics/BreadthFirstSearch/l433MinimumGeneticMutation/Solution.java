package topics.BreadthFirstSearch.l433MinimumGeneticMutation;
import java.util.*;
// two-end breadth first search
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();
        Set<String> dict = new HashSet<>(), visited = new HashSet<>();
        for(String s: bank) dict.add(s);
        if(start.length() != end.length() || !dict.contains(end)) return -1;
        startSet.add(start);
        endSet.add(end);
        visited.add(start);
        visited.add(end);
        int count = 0;
        char[] letters = new char[]{'A', 'C', 'G', 'T'};
        while(!startSet.isEmpty() && !endSet.isEmpty()) {
            if(startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            count++;
            Set<String> next = new HashSet<>();
            for(String s: startSet) {
                char[] sarr = s.toCharArray();
                for(int i = 0; i < s.length(); ++i) {
                    char toChange = sarr[i];
                    for(char c: letters) {
                        sarr[i] = c;
                        String cur = new String(sarr);
                        if(endSet.contains(cur)) return count;
                        if(!dict.contains(cur)) continue;
                        if(visited.add(cur)) next.add(cur);
                    }
                    sarr[i] = toChange;
                }
            }
            startSet = next;
        }
        return -1;
    }
}