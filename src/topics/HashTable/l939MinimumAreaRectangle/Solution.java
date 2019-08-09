package topics.HashTable.l939MinimumAreaRectangle;
import java.util.*;
public class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, Set<Integer>> mapX = new HashMap<>();
        HashMap<Integer, Set<Integer>> mapY = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int[] point: points) {
            Set<Integer> setX = mapX.computeIfAbsent(point[0], x -> new HashSet<>());
            Set<Integer> setY = mapY.computeIfAbsent(point[1], x -> new HashSet<>());
            for(int y1: setX) {
                for(int x1: setY) {
                    if(mapY.get(y1).contains(x1)) {
                        res = Math.min(Math.abs(point[0] - x1) * Math.abs(point[1] - y1), res);
                    }
                }
            }
            setX.add(point[1]);
            setY.add(point[0]);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
