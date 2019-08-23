package topics.DynammicProgramming.l309BestTimetoBuyandSellStockwithCooldown;
// it's basically the same as l123, but we need to record t_(i-2)k0 since we have cool down
public class Solution {
    public int maxProfit(int[] prices) {
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }

        return T_ik0;
    }
}