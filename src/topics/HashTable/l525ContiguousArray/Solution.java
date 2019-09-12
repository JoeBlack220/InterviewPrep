package topics.HashTable.l525ContiguousArray;
import java.util.*;
public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0;
        int res = 0;
        for(int i = 0; i < nums.length; ++i) {
            prefix += (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(prefix)) {
                int prev = map.get(prefix);
                res = Math.max(res, i - prev);
            }
            else {
                map.put(prefix, i);
            }
        }
        return res;
    }
}