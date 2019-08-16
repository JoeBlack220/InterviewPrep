package others.fct.truck;

import java.math.*;

public class Solution {
    public double computeDistance(int[][] speeds, int time) {
        BigDecimal res = new BigDecimal(0);
        final BigDecimal scale = new BigDecimal(60 * 60);
        int[] last = new int[]{0, 0};
        for(int i = 0; i < speeds.length; ++i) {
            int[] speed = speeds[i];
            if(speed[0] <= time) {
                BigDecimal timeTaken = new BigDecimal(speed[0] - last[0]);
                BigDecimal lengthTaken = timeTaken.divide(scale, 20,RoundingMode.HALF_UP).multiply(new BigDecimal(last[1]));
                res = res.add(lengthTaken);
                last = speed;
            }
            if(speed[0] > time || i == speeds.length - 1) {
                BigDecimal timeTaken = new BigDecimal(time - last[0]);
                BigDecimal lengthTaken = timeTaken.divide(scale,20, RoundingMode.HALF_UP).multiply(new BigDecimal(last[1]));
//                BigDecimal lengthTaken = timeTaken.divide(scale,10, RoundingMode.CEILING);
//                System.out.println("l:" + lengthTaken.doubleValue());
                res = res.add(lengthTaken);
                return res.doubleValue();
            }
        }
        return res.doubleValue();
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0, 90}, {300, 80}};
        Solution sol = new Solution();
        System.out.println(sol.computeDistance(test, 600));
    }
}
