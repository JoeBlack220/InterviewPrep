package topics.BitManipulation.l231PowerofTwo;

public class Solution {
    // if a number is power of two, then only it's highest digit is non-zero
    // use n & (n - 1) can remove a number's highest digit
    // then after this operation, if a number is a power of two, the number would be zero
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}

// solution two, use division of log
// might have precision problem
class Solution2 {
    public boolean isPowerOfTwo(int n) {
        double a = Math.log(n) / Math.log(2);
        return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
    }
}