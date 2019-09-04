package topics.BinarySearch.l483SmallestGoodBase;
import java.math.BigInteger;
// n = x^(k-1) + x^(k-2) + ... + x^1 + 1;
// try 2 <= k <= 60
// find x in [2, n)
// n = (x ^ k - 1) / (x - 1)
// n(x - 1) = x^k - 1
// if n(x - 1) > x ^ k - 1 means x is too big
// if n(x - 1) < x ^ k - 1 means x is too small
public class Solution {
    public String smallestGoodBase(String nn) {
        long n = Long.parseLong(nn);
        long res = 0;
        for(int k = 60; k >= 2; k--){
            long s = 2, e = n;
            while(s < e){
                long m = s + (e - s) / 2;

                BigInteger left = BigInteger.valueOf(m);
                left = left.pow(k).subtract(BigInteger.ONE);
                BigInteger right = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
                int cmr = left.compareTo(right);
                if(cmr == 0){
                    res =  m;
                    break;
                } else if(cmr < 0){
                    s = m + 1;
                } else {
                    e = m;
                }
            }

            if(res != 0) break;
        }

        return "" + res;
    }
}
