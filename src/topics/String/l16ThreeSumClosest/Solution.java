package topics.String.l16ThreeSumClosest;
import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int curDiff = Math.abs(target - res);
        for(int i = 0; i < nums.length; ++i) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int cur = nums[i] + nums[l] + nums[r];
                int diff = cur - target;
                if(diff == 0) return target;
                if(Math.abs(diff) < curDiff) {
                    curDiff = Math.abs(diff);
                    res = cur;
                }
                if(diff > 0) r--;
                else l++;
            }
        }
        return res;
    }
}