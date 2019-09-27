package topics.Stack.l496NextGreaterElementI;
import java.util.*;
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        for(int num: nums2) {
            if(stack.isEmpty() || stack.peek() > num) {
                stack.push(num);
            }
            else {
                while(!stack.isEmpty() && stack.peek() < num) {
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; ++i) {
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }

        return res;
    }
}