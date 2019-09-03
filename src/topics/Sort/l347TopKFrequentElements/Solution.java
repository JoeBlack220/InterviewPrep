package topics.Sort.l347TopKFrequentElements;
import java.util.*;
// if we know the maximum value of a field, we can use bucket sort// count sort to sort it in O(n) time and O(n) space
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums) count.put(num, count.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length; i >= 0 && k > 0; --i) {
            if(bucket[i] != null) {
                for(int j = 0; j < bucket[i].size() && k > 0; j++) {
                    list.add(bucket[i].get(j));
                    k--;
                }
            }
        }
        return list;
    }
}