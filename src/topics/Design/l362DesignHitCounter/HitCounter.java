package topics.Design.l362DesignHitCounter;
import java.util.TreeMap;
public class HitCounter {
    TreeMap<Integer, Integer> hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new TreeMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.put(timestamp, hits.getOrDefault(timestamp, 0) + 1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        Integer cur = timestamp;
        while(true) {
            cur = hits.floorKey(cur);
            if(cur == null || cur <= timestamp - 300) break;
            count += hits.get(cur);
            cur = cur - 1;
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
