package topics.DepthFirstSearch.l582KillProcess;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); ++i) {
            if(!map.containsKey(ppid.get(i))) {
                map.put(ppid.get(i), new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> toKill = new LinkedList<>();
        toKill.add(kill);
        while(toKill.size() != 0) {
            int cur = toKill.poll();
            res.add(cur);
            if(map.containsKey(cur)) {
                toKill.addAll(map.get(cur));
            }
        }
        return res;
    }
}