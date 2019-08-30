package topics.DepthFirstSearch.l465OptimalAccountBalancing;
import java.util.*;
public class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] trans: transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) + trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) - trans[2]);
        }

        List<Integer> list = new ArrayList<>();
        for(int v: map.values()) {
            if(v != 0) list.add(v);
        }

        return settle(list, 0);
    }

    private int settle(List<Integer> list, int start) {
        while(start < list.size() && list.get(start) == 0) start++;
        if(start == list.size()) return 0;
        int r = Integer.MAX_VALUE;
        for(int i = start + 1; i < list.size(); ++i) {
            if(list.get(i) * list.get(start) < 0) {
                list.set(i, list.get(i) + list.get(start));
                r = Math.min(r, 1 + settle(list, start + 1));
                list.set(i, list.get(i) - list.get(start));
            }
        }
        return r;
    }
}