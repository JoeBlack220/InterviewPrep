package topics.Math.l7ReverseInteger;

public class Solution {
    // time O(d) d is the digits of the number
    // we don't need a flag to distinguish the situation that x is negative
    // since negative number % 10 will give a negative result
    public int reverse(int x) {
        int res = 0, last = 0;
        while(x != 0) {
            res *= 10;
            // check whether we have an overflow
            if(res / 10 != last) return 0;
            res += x % 10;
            last = res;
            x /= 10;
        }
        return res;
    }
}
