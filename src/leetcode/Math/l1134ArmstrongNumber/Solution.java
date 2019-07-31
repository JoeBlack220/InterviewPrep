package leetcode.Math.l1134ArmstrongNumber;

public class Solution {
    // first count the digits of the number
    // then compute the result according to the rules
    public boolean isArmstrong(int N) {
        int res = 0;
        int temp = N;
        int pow = 0;
        while(temp != 0) {
            temp /= 10;
            pow++;
        }
        temp = N;
        while(temp != 0) {
            res += (int)Math.pow(temp % 10, pow);
            temp /= 10;
        }
        return res == N;
    }
}
