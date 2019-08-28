package topics.Greedy.l435NonoverlappingIntervals;
import java.util.*;
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0] == 0 ? (a[1] - b[1]) : (a[0] - b[0]);
        });
        int count = 0;
        if(intervals.length == 0) return 0;
        int[] last = new int[]{intervals[0][0], intervals[0][1]};
        for(int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            if(cur[0] < last[1]) {
                count++;
                last[1] = Math.min(cur[1], last[1]);
            }
            else last[1] = Math.max(cur[1], last[1]);
        }
        return count;
    }
}