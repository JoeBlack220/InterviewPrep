package topics.Design.l1157OnlineMajorityElementInSubarray;
import java.util.*;
public class MajorityChecker {
    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    public MajorityChecker(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            TreeMap<Integer, Integer> cur = map.computeIfAbsent(arr[i], x -> new TreeMap<>());
            if(cur.size() == 0) cur.put(i, 0);
            else {
                Map.Entry<Integer, Integer> entry = cur.floorEntry(i);
                cur.put(i, entry.getValue() + 1);
            }
        }
    }

    public int query(int left, int right, int threshold) {
        for(Map.Entry<Integer, TreeMap<Integer, Integer>> entry: map.entrySet()) {
            Integer leftIndex = entry.getValue().ceilingKey(left);
            if(leftIndex == null || leftIndex > right) continue;
            Integer rightIndex = entry.getValue().floorKey(right);
            if(entry.getValue().get(rightIndex) - entry.getValue().get(leftIndex) + 1 >= threshold)  return entry.getKey();
        }
        return -1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */