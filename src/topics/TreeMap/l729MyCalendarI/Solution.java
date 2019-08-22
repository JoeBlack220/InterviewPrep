package topics.TreeMap.l729MyCalendarI;
import java.util.*;
public class Solution {
    TreeMap<Integer, Integer> map;
    public Solution() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = map.floorKey(start);
        if (floorKey != null && map.get(floorKey) > start) return false;
        Integer ceilingKey = map.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;
        map.put(start, end);
        return true;
    }
}
