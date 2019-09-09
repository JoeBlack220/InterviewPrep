package topics.Greedy.l857MinimumCosttoHireKWorkers;
import java.util.*;
public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            double r1 = 1.0 * quality[a] / wage[a];
            double r2 = 1.0 * quality[b] / wage[b];
            return Double.compare(r2, r1);
        });
        for(int i = 0; i < quality.length; ++i) pq.offer(i);
        PriorityQueue<Integer> use = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0;
        double curRatio = 0, res = 0;
        for(int i = 0; i < K; ++i) {
            int index = pq.poll();
            curRatio = 1.0 * wage[index] / quality[index];
            total += quality[index];
            use.offer(quality[index]);
            // System.out.println(curRatio);
        }
        res = total * curRatio;

        while(!pq.isEmpty()) {
            int index = pq.poll();
            curRatio = 1.0 * wage[index] / quality[index];
            total += quality[index];
            use.offer(quality[index]);
            total -= use.poll();
            res = Math.min(total * curRatio, res);
        }

        return res;
    }
}