package topics.Math.l587ErecttheFence;
import java.util.*;
// graham scan
// time O(nlogn)
// we first find the bottom left point of all points, then sort all the points by polar angle order
// to the bottom left point
// beware that for the two edges connected to the bottom left point,
// we should do extra sort considering their distances to the pivot point
// the points on the starting edge should be in ascending order and the ending edge should be in descending order
// this way we can correctly visit all the points in right order
public class Solution {
    public int[][] outerTrees(int[][] points) {
        if(points.length < 2) return points;
        int[] bottom = lowest(points);
        sortByPolar(points, bottom);
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for(int i = 2; i < points.length; ++i) {
            int[] top = stack.pop();
            while(ccw(stack.peek(), top, points[i]) < 0) top = stack.pop();
            stack.push(top);
            stack.push(points[i]);
        }
        int[][] res = new int[stack.size()][];
        int index = 0;
        for(int[] p: stack) res[index++] = p;
        return res;
    }
    // return positive if counter clock wise
    private int ccw(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }

    private int dist(int[] x, int[] y) {
        int xDiff = x[0] - y[0];
        int yDiff = x[1] - y[1];
        return xDiff * xDiff + yDiff * yDiff;
    }
    private int[] lowest(int[][] points) {
        int[] res = new int[2];
        Arrays.fill(res, Integer.MAX_VALUE);
        for(int[] point: points) {
            if(point[1] < res[1] || point[1] == res[1] && point[0] < res[0]) {
                res[0] = point[0];
                res[1] = point[1];
            }
        }
        return res;
    }
    private void exch(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private void sortByPolar(int[][] points, int[] lowest) {
        Arrays.sort(points, (x, y) -> {
            int compccw = ccw(x, lowest, y);
            return compccw == 0 ? dist(x, lowest) - dist(y, lowest) : compccw;
        });
        int[] back = points[points.length - 1];
        int i = points.length - 2;
        while(i >= 0 && ccw(lowest, back, points[i]) == 0) i--;
        int l = i + 1, r = points.length - 1;
        while(l < r) {
            exch(points, l++, r--);
        }
    }
}