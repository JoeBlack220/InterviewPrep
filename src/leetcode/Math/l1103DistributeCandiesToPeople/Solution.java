package leetcode.Math.l1103DistributeCandiesToPeople;

public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int cur = 0;
        int num = 0;
        while(candies != 0) {
            cur = Math.min(cur + 1, candies);
            res[num % num_people] += cur;
            num++;
            candies -= cur;
        }
        return res;
    }
}
