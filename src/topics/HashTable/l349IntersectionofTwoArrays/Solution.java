package topics.HashTable.l349IntersectionofTwoArrays;
import java.util.*;
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums1) {
            set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for(int num: nums2) {
            if(set.contains(num)) res.add(num);
        }
        int[] ret = new int[res.size()];
        int index = 0;
        for(int num: res) {
            ret[index++] = num;
        }
        return ret;
    }
}
