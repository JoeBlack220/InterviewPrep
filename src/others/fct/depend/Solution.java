package others.fct.depend;
import java.util.*;
public class Solution {
    public int depend(Map<String, List<String>> map, String toBuild) {
        int res = 0;
        Deque<String> stack = new LinkedList<>();
        stack.push(toBuild);
        Set<String> visited = new HashSet<>();
        while(!stack.isEmpty()) {
            String cur = stack.pop();
            visited.add(cur);
            List<String> curDepend = map.get(cur);
            if(curDepend == null) continue;
            for(String s: curDepend) {
                if(!visited.contains(s)) stack.push(s);
            }
        }
        return visited.size();
    }

    public static void main(String[] args) {
        Map<String, List<String>> test = new HashMap<>();
        test.put("a", new LinkedList<>());
        test.get("a").add("b");
        test.get("a").add("c");
        test.get("a").add("d");
        test.put("b", new LinkedList<>());
        test.get("b").add("e");
        test.get("b").add("c");
        test.put("c", new LinkedList<>());
        test.get("c").add("g");
        Solution sol = new Solution();
        System.out.println(sol.depend(test, "a"));
    }
}
