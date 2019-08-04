package leetcode.Array.l849MaximizeDistancetoClosestPerson;

public class Solution {
    // scan the array twice
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] left = new int[len];
        int last = -len;
        int max = 0;
        for(int i = 0; i < len; ++i) {
            if(seats[i] == 1) last = i;
            left[i] = i - last;
        }
        for(int i = len - 1; i >= 0; --i) {
            if(seats[i] == 1) last = i;
            left[i] = Math.min(Math.abs(last - i), left[i]);
            max = Math.max(left[i], max);
        }
        return max;
    }
    // one pass solution
    // when we find two people, the largest distance should be the distance between those two then divide by two
    public int maxDistToClosest2(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }
}
