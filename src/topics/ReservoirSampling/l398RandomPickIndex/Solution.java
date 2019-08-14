package topics.ReservoirSampling.l398RandomPickIndex;
import java.util.Random;
public class Solution {
    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            // this probability is 1 / (1 + count), which is exactly 1 / (1 + k)
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }
}

