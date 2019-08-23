package topics.DynammicProgramming.l122BestTimetoBuyandSellStockII;


// general solution to solve best time to buy or sell stocks
// t[i][k][1] means the maximum profit you can get by holding one stock on i-th day with k maximum transactions
// t[i][k][0] means the maximum profit you can get by holding no stock on i-th day with k maximum transactions
// we can choose to buy, sell or rest on i-th day
// we have a basic case that t[i][0][0] = 0, t[i][0][1] = t[-1][k][1] = -inf
// t[i][1][1] = max(t[i-1][k][1], t[i-1][k - 1][0] - prices[i])
// if we choose to sell t[i][k][1] = t[i - 1][k - 1][0] + prices[i]
// if we choose to rest t[i][k][1] = t[i - 1][k][1]
// t[i][k][0] is the answer we want
public class Solution {
    public int maxProfit(int[] prices) {
        int t_ik0 = 0;
        int t_ik1 = Integer.MIN_VALUE;
        for(int price: prices) {
            t_ik0 = Math.max(t_ik0, t_ik1 + price);
            t_ik1 = Math.max(t_ik1, t_ik0 - price);
        }
        return t_ik0;
    }
}
