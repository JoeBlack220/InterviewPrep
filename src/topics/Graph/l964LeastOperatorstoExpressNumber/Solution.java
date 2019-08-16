package topics.Graph.l964LeastOperatorstoExpressNumber;
import java.util.*;
public class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.opNums != b.opNums) return a.opNums - b.opNums;
            else return a.target - b.target;
        });
        Set<Integer> visited = new HashSet<>();
        pq.offer(new Pair(0, target));
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            // System.out.println(cur.target + "," + cur.opNums);
            if(cur.target == 0) return cur.opNums - 1;
            visited.add(cur.target);
            int k = (int) (Math.log(cur.target) / Math.log(x));
            int next1 = (int) (Math.pow(x, k + 1) - cur.target);
            int next2 = (int) (cur.target - Math.pow(x, k));
            if(!visited.contains(next1)) {
                pq.offer(new Pair(cur.opNums + k + 1, next1));
            }
            if(!visited.contains(next2)) {
                pq.offer(new Pair(cur.opNums + (k == 0 ? 2 : k), next2));
            }
        }
        return -1;
    }

    class Pair{
        int opNums;
        int target;
        public Pair(int num, int t) {
            opNums = num;
            target = t;
        }
    }
}