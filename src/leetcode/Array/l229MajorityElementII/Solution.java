package leetcode.Array.l229MajorityElementII;
import java.util.*;
public class Solution {

    // Boyer-Moore Majority Vote algorithm
    // space O(1) time O(n)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0)
            return res;

        int num1 = nums[0]; int num2 = nums[0]; int count1 = 0; int count2 = 0 ;

        for (int val : nums) {
            if(val == num1)
                count1++;
            else if (val == num2)
                count2++;
            else if (count1 == 0) {
                num1 = val;
                count1++;
            }
            else if (count2 == 0) {
                num2 = val;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int val : nums) {
            if(val == num1)
                count1++;
            else if(val == num2)
                count2++;
        }
        if(count1 > nums.length/3)
            res.add(num1);
        if(count2 > nums.length/3)
            res.add(num2);
        return res;
    }
}

class Solution2 {
    // generalize to k situation
    public List<Integer> majorityElement(int[] nums) {
        int k = 3;
        int targetFreq = nums.length / k;
        Map<Integer, Integer> kCounters = new HashMap();
        Map<Integer, Integer> freq = new HashMap();
        // 1st pass to build kCounters and freq
        for (int num : nums) {
            // update freq
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            // update kCounters
            if (kCounters.containsKey(num) || kCounters.size() < k) {
                kCounters.put(num, kCounters.getOrDefault(num, 0) + 1);
            } else {
                // decrease all other keys, erase them if count falls to zero
                Set<Integer> keySet = new HashSet(kCounters.keySet()); // has to use a separate set to avoid ConcurrentModificationException
                for (int candidate : keySet) {
                    kCounters.put(candidate, kCounters.get(candidate) - 1);
                    if (kCounters.get(candidate) == 0) kCounters.remove(candidate);
                }
            }
        }
        // 2nd pass to get valid candidates
        List<Integer> majorities = new ArrayList();
        for (int candidate : kCounters.keySet()) {
            if (freq.get(candidate) > targetFreq) majorities.add(candidate);
        }
        return majorities;
    }
}
