package topics.Stack.l456acbPattern;
import java.util.*;
public class Solution {
    public boolean find132pattern(int[] nums) {
        int ak = Integer.MIN_VALUE;
        // numbers in the stack, current qualified aj, candidate ak
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < ak) {
                return true;
            }
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    ak = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}