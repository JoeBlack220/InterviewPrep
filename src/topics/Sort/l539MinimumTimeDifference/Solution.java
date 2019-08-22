package topics.Sort.l539MinimumTimeDifference;
import java.util.*;
// bucket sort
// space O(1440) time O(1440)
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[60 * 24];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String s: timePoints) {
            int h = Integer.parseInt(s.substring(0, 2));
            int m = Integer.parseInt(s.substring(3));
            int minutes = h * 60 + m;
            min = Math.min(min, minutes);
            max = Math.max(max, minutes);
            if(mark[minutes]) return 0;
            mark[minutes] = true;
        }

        int prev = 0, minDiff = Integer.MAX_VALUE;
        for(int i = min; i <= max; ++i) {
            if(mark[i]){
                if(i == min){
                    minDiff = Math.min(minDiff, Math.min(max - min, 1440 - max + min));
                }
                else{
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        return minDiff;
    }
}
