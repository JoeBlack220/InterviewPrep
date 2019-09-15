package topics.Math.l172FactorialTrailingZeroes;

public class Solution {
    public int trailingZeroes(int n) {
        int temp = 0;
        while(n != 0){
            n = n / 5;
            temp += n;
        }
        return temp;
    }
}