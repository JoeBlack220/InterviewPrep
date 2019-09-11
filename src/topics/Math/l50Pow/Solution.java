package topics.Math.l50Pow;

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n < 0) {
            if(n == Integer.MIN_VALUE) {
                n += 2; //如果 += 1 那么当x是负数的时候会改变x的符号。
            }
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}