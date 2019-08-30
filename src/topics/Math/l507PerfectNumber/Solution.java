package topics.Math.l507PerfectNumber;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        if(num <= 1) return false;
        for(int i = 1; i <= (int)Math.sqrt(num); ++i) {
            if(num % i == 0) {
                if(i == 1) sum += i;
                else {
                    sum += i;
                    sum += num / i;
                }
            }
            if(sum > num) return false;
        }
        return sum == num;
    }
}
