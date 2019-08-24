package topics.Sort.l480SlidingWindowMedian;
import java.util.*;
public class Solution {
    // maintain two priority queue
    // when k is odd first.size() = second.size() + 1
    // when k is even first.size() = second.size()
    // first is a max heap and second is a min heap
    // when k is odd, current median is first.peek()
    // when k is even current median is (first.peek() + second.peek()) / 2.0
    // beware of the overflow
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        if(len <= 0) return new double[]{};
        double[] res = new double[len];
        PriorityQueue<Integer> first = new PriorityQueue<>(k / 2 + 1, Collections.reverseOrder());
        PriorityQueue<Integer> second = new PriorityQueue<>(k / 2 + 1);
        for(int i = 0; i < k; ++i) addNum(first, second, nums[i]);
        if(k % 2 == 0) res[0] = ((double)first.peek() + (double)second.peek()) / 2.0;
        else res[0] = first.peek();
        // for(int num: second) System.out.println(num);
        for(int i = 1; i < len; ++i) {
            addNum(first, second, nums[i + k - 1]);
            removeNum(first, second, nums[i - 1]);
            if(k % 2 == 0) res[i] = ((double)first.peek() + (double)second.peek()) / 2.0;
            else res[i] = first.peek();
        }
        return res;
    }

    private void addNum(PriorityQueue<Integer> first, PriorityQueue<Integer> second, int num) {
        if(second.size() != 0 && second.peek() < num) {
            second.offer(num);
            if(second.size() > first.size()) first.offer(second.poll());
        }
        else {
            first.offer(num);
            if(first.size() > second.size() + 1) second.offer(first.poll());
        }
    }

    private void removeNum(PriorityQueue<Integer> first, PriorityQueue<Integer> second, int num) {
        if(num > first.peek()) {
            second.remove(num);
            if(first.size() > second.size() + 1) second.offer(first.poll());
        }
        else {
            first.remove(num);
            if(second.size() > first.size()) first.offer(second.poll());
        }
    }
}