package leetcode.Array.l561ArrayPartition;
import java.util.*;
public class Solution {
    // sort then add the alternate entries
    // time O(nlogn) space O(1)
//    Assume in each pair i, bi >= ai.
//            Denote Sm = min(a1, b1) + min(a2, b2) + ... + min(an, bn). The biggest Sm is the answer of this problem. Given 1, Sm = a1 + a2 + ... + an.
//            Denote Sa = a1 + b1 + a2 + b2 + ... + an + bn. Sa is constant for a given input.
//    Denote di = |ai - bi|. Given 1, di = bi - ai. Denote Sd = d1 + d2 + ... + dn.
//            So Sa = a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + dn = 2Sm + Sd => Sm = (Sa - Sd) / 2. To get the max Sm, given Sa is constant, we need to make Sd as small as possible.
//    So this problem becomes finding pairs in an array that makes sum of di (distance between ai and bi) as small as possible. Apparently, sum of these distances of adjacent elements is the smallest. If that's not intuitive enough, see attached picture. Case 1 has the smallest Sd.
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2) sum += nums[i];
        return sum;
    }

    // count sort
    // time O(n) space O(n)
    public int arrayPairSum1(int[] nums) {
        int[] exist = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            exist[nums[i] + 10000]++;
        }
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < exist.length; i++) {
            while (exist[i] > 0) {
                if (odd) {
                    sum += i - 10000;
                }
                odd = !odd;
                exist[i]--;
            }
        }
        return sum;
    }
}
