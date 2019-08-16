package topics.Math.l1073AddingTwoNegabinaryNumbers;
import java.util.*;
public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int car = 0, i = arr1.length - 1, j = arr2.length - 1;
        while(car != 0 || i >= 0 || j >= 0) {
            if(i >= 0) car += arr1[i--];
            if(j >= 0) car += arr2[j--];
            list.add(car & 1);
            car = -(car >> 1);
        }
        while(list.size() > 1 && list.get(list.size() - 1) == 0) list.remove(list.size() - 1);
        int[] res = new int[list.size()];
        for(int m = list.size() - 1; m >= 0; m--) {
            res[list.size() - 1 - m] = list.get(m);
        }
        return res;
    }
}