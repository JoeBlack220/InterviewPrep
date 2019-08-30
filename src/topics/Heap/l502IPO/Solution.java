package topics.Heap.l502IPO;
import java.util.*;
public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pro = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> cap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int i = 0; i < Profits.length; ++i) cap.offer(new int[]{Profits[i], Capital[i]});

        for(int i = 0; i < k; ++i) {
            while(!cap.isEmpty() && cap.peek()[1] <= W) {
                pro.offer(cap.poll());
            }
            if(pro.isEmpty()) return W;

            W += pro.poll()[0];

        }
        return W;
    }

}