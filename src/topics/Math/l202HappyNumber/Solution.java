package topics.Math.l202HappyNumber;
import java.util.*;
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1) {
            n = compute(n);
            if(!set.add(n)) return false;
        }
        return true;
    }

    private int compute(int n) {
        int res = 0;
        while(n != 0) {
            int d = n % 10;
            res += d * d;
            n /= 10;
        }
        return res;
    }
}