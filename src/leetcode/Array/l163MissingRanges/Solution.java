package leetcode.Array.l163MissingRanges;
import java.util.*;
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            findMissingRangesHelper(res, lower, upper);
            return res;
        }
        int n = nums.length;
        if (nums[0] != Integer.MIN_VALUE) {
            findMissingRangesHelper(res, lower, nums[0] - 1);
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] != nums[i - 1]) {
                findMissingRangesHelper(res, nums[i - 1] + 1, nums[i] - 1);
            }
        }
        if (nums[n - 1] != Integer.MAX_VALUE) {
            findMissingRangesHelper(res, nums[n - 1] + 1, upper);
        }
        return res;
    }

    private void findMissingRangesHelper(List<String> res, int s, int e) {
        if (s == e) {
            res.add(String.valueOf(s));
        } else if (s < e) {
            res.add(s + "->" + e);
        }
    }
}
