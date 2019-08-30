package topics.Array.l238ProductofArrayExceptSelf;
import java.util.Arrays;
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int cur = 1;
        for(int i = 0; i < nums.length; ++i) {
            res[i] *= cur;
            cur *= nums[i];
        }
        cur = 1;
        for(int i = nums.length - 1; i >= 0; --i) {
            res[i] *= cur;
            cur *= nums[i];
        }
        return res;
    }
}
