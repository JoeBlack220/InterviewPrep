package topics.Heap.l759EmployeeFreeTime;
import java.util.*;

import datastructure.Interval;
// using a priority queue
public class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<List<Interval>> pq = new PriorityQueue<>((a, b) -> {
            return a.get(0).start - b.get(0).start;
        });

        for(List<Interval> list: schedule) {
            if(list.size() > 0) pq.offer(list);
        }
        int lastEnd = Integer.MIN_VALUE;
        List<Interval> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            while(!pq.isEmpty() && pq.peek().get(0).start <= lastEnd) {
                List<Interval> cur = pq.poll();
                lastEnd = Math.max(lastEnd, cur.get(0).end);
                cur.remove(0);
                if(cur.size() != 0) pq.offer(cur);
            }
            if(!pq.isEmpty()) {
                int end = pq.peek().get(0).start;
                if(lastEnd != Integer.MIN_VALUE) res.add(new Interval(lastEnd, end));
                lastEnd = end;
            }
        }
        return res;
    }
}

// actually, it doesn't matter which working interval belongs to who, we can just add them all to the list

class Solution2 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        List<Interval> res = new ArrayList<>();

        for(List<Interval> employee: schedule) {
            list.addAll(employee);
        }

        Collections.sort(list, (a, b) -> a.start - b.start);

        int lastEnd = Integer.MIN_VALUE;
        for(Interval i: list) {
            if(i.start <= lastEnd) lastEnd = Math.max(lastEnd, i.end);
            else {
                int newEnd = i.end;
                if(lastEnd != Integer.MIN_VALUE) res.add(new Interval(lastEnd, i.start));
                lastEnd = newEnd;
            }
        }
        return res;
    }
}