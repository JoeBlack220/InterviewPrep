package topics.Sort.l973KClosestPointstoOrigin;
import java.util.Arrays;
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int start = 0, end = points.length - 1;
        while(start < end) {
            int mid = partition(points, start, end);
            if(mid == K) break;
            else if(mid > K) end = mid - 1;
            else start = mid + 1;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int start, int end) {
        if(start >= end) return start;
        int[] pivot = points[end];
        int curIndex = start;
        for(int i = start; i < end; ++i) {
            if(compare(points[i], pivot)) exch(points, curIndex++, i);
        }
        exch(points, curIndex, end);
        return curIndex;
    }

    private void exch(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private boolean compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1] <= 0;
    }
}