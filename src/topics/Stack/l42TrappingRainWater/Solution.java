package topics.Stack.l42TrappingRainWater;
import java.util.*;
// maintain a monotonic decreasing stack
// when we encounter a height that is higher than one height in the stack
// we compute the water that trapped by the current height
class Solution {

    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        int res = 0;
        while(i < height.length) {
            if(stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i++);
            }
            else {
                int pre = stack.pop();
                if(!stack.isEmpty()) {
                    int minHeight = Math.min(height[i], height[stack.peek()]);
                    res += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return res;
    }
}