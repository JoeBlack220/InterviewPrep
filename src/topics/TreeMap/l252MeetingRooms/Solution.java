package topics.TreeMap.l252MeetingRooms;
import java.util.*;
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] interval: intervals) {
            Integer floorKey = map.floorKey(interval[0]);
            if (floorKey != null && map.get(floorKey) > interval[0]) return false;
            Integer ceilingKey = map.ceilingKey(interval[0]);
            if (ceilingKey != null && ceilingKey < interval[1]) return false;

            map.put(interval[0], interval[1]);
        }
        return true;
    }
}