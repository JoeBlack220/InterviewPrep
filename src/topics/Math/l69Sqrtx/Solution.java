package topics.Math.l69Sqrtx;

public class Solution {
    // binary search idea
    // since we only to compute floor sqrt(x)
    // the end condition could be decided easily
    // time O(logn) space O(1)
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            // use x / mid instead of mid * mid to avoid overflow
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    // Newton's method
    // start with an initial value y(let's pick y = 1)
    // Repeatedly improve the estimate by taking the mean of y and x/y
    public int mySqrt2(int x) {
        if (x == 1)
            return 1;
        float y = 1;
        float old = 0;
        while ((int) (old - y) != 0) {
            old = y;
            y = (y + x * 1.0f / y) * 0.5f;  //Iterative Convergence
        }
        int res = (int) y;
        return res * res > x ? res - 1 : res;//accommodate the Q
    }
}