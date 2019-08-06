package leetcode.TreeMap.l731MyCalendarII;
import java.util.TreeMap;
public class MyCalendarTwo {
    // Think of this as "scanning" from left to right with a "vertical laser". Every endpoint (a start point, or an end point) is an event. A start point is +1, an end point is -1. The accumulated value "count" would be the number of "active" intervals which is cut by the vertical laser.
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    public boolean book(int s, int e) {
        map.put(s, map.getOrDefault(s, 0) + 1);
        map.put(e, map.getOrDefault(e, 0) - 1);

        int cnt = 0, k = 0;
        for (int v : map.values()) {
            k = Math.max(k, cnt += v);
            if (k > 2) {
                map.put(s, map.get(s) - 1);
                map.put(e, map.get(e) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */