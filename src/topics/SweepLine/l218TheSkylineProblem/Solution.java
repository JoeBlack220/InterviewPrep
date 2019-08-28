package topics.SweepLine.l218TheSkylineProblem;
import java.util.*;

// when the highest height of the current skyline changes, we should add the update points
// so we need to record the previous highest height
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int len = buildings.length;
        int[][] points = new int[len * 2][2];
        int index = 0;

        for(int[] building: buildings) {
            points[index][0] = building[0];
            points[index][1] = building[2];
            index++;
            points[index][0] = building[1];
            points[index][1] = -building[2];
            index++;
        }

        Arrays.sort(points, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return b[1] - a[1];
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<List<Integer>> res = new LinkedList<>();
        map.put(0, 1);
        int prev = 0;
        for(int[] point: points) {
            if(point[1] < 0) {
                map.put(-point[1], map.get(-point[1]) - 1);
                if(map.get(-point[1]) == 0) map.remove(-point[1]);
            }
            else {
                map.put(point[1], map.getOrDefault(point[1], 0) + 1);
            }
            int big = map.lastKey();
            if(big != prev) {
                prev = big;
                List<Integer> cur = new ArrayList<>();
                cur.add(point[0]);
                cur.add(big);
                res.add(cur);
            }
        }
        return res;
    }
}
