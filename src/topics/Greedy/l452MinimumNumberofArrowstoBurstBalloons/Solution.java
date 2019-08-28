package topics.Greedy.l452MinimumNumberofArrowstoBurstBalloons;
import java.util.*;
public class Solution {
    // the problem is to find the maximum number of non-overlap intervals
    // just like leet code 435
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            int res = a[0] - b[0];
            return res == 0 ? a[1] - b[1] : res;
        });
        int count = 0;
        if(points.length == 0) return 0;
        int last = points[0][1];
        for(int i = 1; i < points.length; ++i) {
            int[] point = points[i];
            if(point[0] <= last) {
                count++;
                last = Math.min(last, point[1]);
            }
            else last = point[1];
        }
        return points.length - count;
    }
}
