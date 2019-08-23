package topics.DynammicProgramming.l123BestTimetoBuyandSellStockIII;
// please refer to the explanation of l121
public class Solution {
    public int maxProfit(int[] prices) {
        int t_i10 = 0, t_i11 = Integer.MIN_VALUE;
        int t_i20 = 0, t_i21 = Integer.MIN_VALUE;

        for(int price: prices) {
            t_i10 = Math.max(t_i10, t_i11 + price);
            t_i11 = Math.max(t_i11, -price);
            t_i20 = Math.max(t_i20, t_i21 + price);
            t_i21 = Math.max(t_i21, t_i10 - price);
        }
        return t_i20;
    }
}
