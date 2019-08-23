package topics.DynammicProgramming.l714BestTimetoBuyandSellStockwithTransactionFee;
// just like l122, but when we sell stocks we should consider transaction fee
// add a if statement to avoid overflow
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int t_ik0 = 0, t_ik1 = Integer.MIN_VALUE;
        for(int price: prices) {
            if(price >= fee) t_ik0 = Math.max(t_ik0, t_ik1 + price - fee);
            t_ik1 = Math.max(t_ik1, t_ik0 - price);
        }
        return t_ik0;
    }
}
