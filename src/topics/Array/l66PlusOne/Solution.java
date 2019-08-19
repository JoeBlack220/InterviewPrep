package topics.Array.l66PlusOne;
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
// without using list, save a lot
class Solution2 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = new int[len];
        int car = 1;
        for(int i = len - 1; i >= 0; --i) {
            int cur = car + digits[i];
            res[i] = cur % 10;
            car = cur / 10;
        }

        if(car == 0) return res;
        else {
            int[] res1 = new int[len + 1];
            res1[0] = 1;
            for(int i = 0; i < len; ++i) {
                res1[i + 1] = res[i];
            }
            return res1;
        }
    }
}
