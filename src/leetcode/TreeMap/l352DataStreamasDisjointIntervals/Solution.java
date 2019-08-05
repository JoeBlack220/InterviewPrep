package leetcode.TreeMap.l352DataStreamasDisjointIntervals;
import java.util.TreeMap;
import java.util.Map;
public class Solution {
    TreeMap<Integer, int[]> map;
    /** Initialize your data structure here. */
    public Solution() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, int[]> h = map.ceilingEntry(val);
        Map.Entry<Integer, int[]> l = map.floorEntry(val);
        if(h != null && l != null && h.getKey() == val + 1 && l.getValue()[1] == val - 1) {
            l.getValue()[1] = h.getValue()[1];
            map.remove(h.getKey());
        }
        else if(h != null && h.getKey() == val + 1) {
            map.put(val, new int[]{val, h.getValue()[1]});
            map.remove(h.getKey());
        }
        else if(l != null && l.getValue()[1] == val - 1) {
            l.getValue()[1] = val;
        }
        else if(l != null && l.getValue()[1] >= val) return;
        else {
            map.put(val, new int[]{val, val});
        }

    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][];
        int index = 0;
        for(Map.Entry<Integer, int[]> entry: map.entrySet()) {
            res[index] = entry.getValue();
            index++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
