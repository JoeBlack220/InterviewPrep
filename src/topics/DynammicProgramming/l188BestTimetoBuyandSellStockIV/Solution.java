package topics.DynammicProgramming.l188BestTimetoBuyandSellStockIV;
import java.util.*;
// please refer to the explanation of l121
// if k is very big we may get mle, so when k is bigger than the length of the prices
// we can use the solution of l123 (since we will never actually do more than k transactions) to save memory
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length >>> 1) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }

        return T_ik0[k];
    }
}