package leetcode.Array.l1133LargestUniqueNumber;
import java.util.Map;
import java.util.HashMap;
public class Solution {
    // can handle with negative cases
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: A) map.put(i, map.getOrDefault(i, 0) + 1);
        Integer res = null;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1 && (res == null || res < entry.getKey())) res = entry.getKey();
        }
        return res == null ? -1 : res;
    }
    // since we know the 0 <= A[i] <= 1000 in this question
    // we can only use an array of size 1001 to deal with it
    public int largestUniqueNumber1(int[] A) {
        int res = -1;
        int[] temp = new int[1001];
        for(int i = 0; i < A.length; i++) {
            temp[A[i]]++;
        }
        for(int i = temp.length-1; i >= 0; i--) {
            if(temp[i] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }

}
