package topics.DynammicProgramming.l121BestTimetoBuyandSellStock;

public class Solution {
    // straight forward
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        int res = 0;
        for(int num: prices) {
            if(num < low) {
                low = num;
                hi = Integer.MIN_VALUE;
            }
            else if(num > hi) {
                hi = num;
                res = Math.max(res, hi - low);
            }
        }
        return res;
    }
}

// Kadane's Algorithm
// convert the problem to max subarray
// problem by changing the input from prices to the differences to the last day
class Solution2 {
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
// general solution to solve best time to buy or sell stocks
// t[i][k][1] means the maximum profit you can get by holding one stock on i-th day with k maximum transactions
// t[i][k][0] means the maximum profit you can get by holding no stock on i-th day with k maximum transactions
// we can choose to buy, sell or rest on i-th day
// we have a basic case that t[i][0][0] = 0, t[i][0][1] = t[-1][k][1] = -inf
// t[i][1][1] = max(t[i-1][1][1], t[i-1][0][0] - prices[i]) = max(t[i-1][1][1], -prices[i])
// if we choose to sell t[i][1][1] = t[i - 1][0][0] + prices[i]
// if we choose to rest t[i][1][1] = t[i - 1][k][1]
// t[i][k][0] is the answer we want
class Solution3 {
    public int maxProfit(int[] prices) {
        int t_i11 = Integer.MIN_VALUE;
        int t_i10 = 0;
        for(int price: prices) {
            t_i10 = Math.max(t_i10, t_i11 + price);
            t_i11 = Math.max(t_i11, -price);
        }
        return t_i10;
    }
}