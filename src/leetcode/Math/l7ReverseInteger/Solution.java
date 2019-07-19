package leetcode.Math.l7ReverseInteger;

public class Solution {
    // time O(d) d is the digits of the number

    public int reverse(int x) {
        int res = 0, last = 0;
        while(x != 0) {
            res *= 10;
            if(res / 10 != last) return 0;
            res += x % 10;
            last = res;
            x /= 10;
        }
        return res;
    }
}
