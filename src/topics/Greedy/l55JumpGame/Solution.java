package topics.Greedy.l55JumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int cur = 0;
        while(cur <= max) {
            max = Math.max(max, nums[cur] + cur);
            if(max >= len - 1) return true;
            cur++;
        }
        return false;
    }
}
