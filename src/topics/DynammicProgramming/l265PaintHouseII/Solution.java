package topics.DynammicProgramming.l265PaintHouseII;

public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int min = 0, secondMin = 0, minIndex = 0;
        for(int i = 0; i < costs.length; ++i) {
            int curMin = Integer.MAX_VALUE, curSecondMin = Integer.MAX_VALUE, curMinIndex = 0;
            for(int j = 0; j < costs[0].length; ++j) {
                int current = 0;
                if(i == 0) {
                    current = costs[i][j];
                }
                else {
                    if(j == minIndex) {
                        current = costs[i][j] + secondMin;
                    }
                    else {
                        current = costs[i][j] + min;
                    }
                }

                if(current < curMin) {
                    curSecondMin = curMin;
                    curMin = current;
                    curMinIndex = j;
                }
                else if(current < curSecondMin) {
                    curSecondMin = current;
                }
            }
            min = curMin;
            minIndex = curMinIndex;
            secondMin = curSecondMin;
            // System.out.println(min);
            // System.out.println(secondMin);
        }

        return min;
    }
}