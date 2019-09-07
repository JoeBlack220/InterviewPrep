package topics.Greedy.l1183MaximumNumberofOnes;
import java.util.*;
public class Solution {
    public int maximumNumberOfOnes(int w, int h, int sl, int mo) {
        int ans = 0;
        int[][] mcs = new int[sl][sl];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                mcs[i%sl][j%sl]++;
            }
        }
        PriorityQueue<Integer> mcst = new PriorityQueue<>();
        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < sl; j++) {
                mcst.add(-mcs[i][j]);
            }
        }
        for (int i = 0; i < mo; i++) {
            ans -= mcst.poll();
        }
        return ans;
    }
}