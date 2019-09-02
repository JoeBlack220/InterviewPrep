package topics.DynammicProgramming.l1066CampusBikesII;
import java.util.*;
// state compression using bit mask and dynamic programming
public class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int workersNum = workers.length;
        int bikeNum = bikes.length;
        int[][] dp = new int[workersNum][1 << bikeNum];
        for(int[] d: dp) Arrays.fill(d, Integer.MAX_VALUE / 2);
        for(int i = 0; i < bikeNum; ++i) {
            dp[0][1 << i] = Math.abs(workers[0][0] - bikes[i][0])
                    + Math.abs(workers[0][1] - bikes[i][1]);
        }

        for(int i = 1; i < workersNum; ++i) {
            for(int j = 0; j < bikeNum; ++j) {
                int dist = Math.abs(workers[i][0] - bikes[j][0])
                        + Math.abs(workers[i][1] - bikes[j][1]);
                for(int k = 1; k < (1 << bikeNum); ++k) {
                    if(((1 << j) & k) == 0) {
                        int n = k | (1 << j);
                        dp[i][n] = Math.min(dp[i - 1][k] + dist, dp[i][n]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int candidate: dp[workersNum - 1]) {
            res = Math.min(res, candidate);
        }
        return res;
    }
}