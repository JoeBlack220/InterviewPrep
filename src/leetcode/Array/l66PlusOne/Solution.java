package leetcode.Array.l66PlusOne;
import java.util.*;
public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();
        int car = 1;
        for(int i = digits.length - 1; i >= 0; --i) {
            int cur = digits[i] + car;
            if(cur >= 10) {
                car = 1;
                cur = cur % 10;
            }
            else car = 0;
            list.add(cur);
        }
        if(car != 0) list.add(car);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i) {
            res[list.size() - 1 - i] = list.get(i);
        }
        return res;
    }
}
