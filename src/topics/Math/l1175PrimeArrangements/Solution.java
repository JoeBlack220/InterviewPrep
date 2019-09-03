package topics.Math.l1175PrimeArrangements;
// remember that, even though you mod 1e9 + 7 every time after a multiplication
// you can still get an overflow
// use long to avoid this situation
public class Solution {
    public int numPrimeArrangements(int n) {
        int mod = (int)(1e9 + 7);
        int prime = 0, nonPrime = 0;

        long res = 1;
        for(int i = 1; i <= n; ++i) {
            if(isPrime(i)) {
                res = res * (++prime) % mod;
            }
            else {
                res = res * (++nonPrime) % mod;
            }
        }

        return (int)res;
    }

    private boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i < n / 2 + 1; ++i) {
            if(n % i == 0) return false;
        }
        return true;
    }
}