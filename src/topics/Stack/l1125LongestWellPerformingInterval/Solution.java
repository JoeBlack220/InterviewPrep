package topics.Stack.l1125LongestWellPerformingInterval;
import java.util.*;
public class Solution {
    // straight forward solution TLE
    public int longestWPI(int[] hours) {
        int countTiring = 0;
        int countNon = 0;
        int res = 0;
        for(int i = 0; i < hours.length; ++i) {
            int hour = hours[i];
            if(hour > 8) countTiring++;
            else countNon++;
            int curTiring = countTiring;
            int curNon = countNon;
            int pointer = 0;
            while(curTiring <= curNon && pointer <= i) {
                int last = hours[pointer++];
                if(last > 8) curTiring--;
                else curNon --;
            }
            if(curTiring > curNon) res = Math.max(res, curTiring + curNon);
        }
        return res;
    }
    // using HashMap
    public int longestWPI1(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }

    // using prefixsum
    public int longestWPI2(int[] hours) {
        int[] pre = new int[hours.length+1];
        int max = 0;
        for(int i=1; i <= hours.length; i++){
            if(hours[i-1] > 8){
                max = 1;
                pre[i] = pre[i-1]+1;
            }else
                pre[i] = pre[i-1]-1;
        }
        for(int i=0; i <= hours.length; i++){
            for(int j=hours.length; j > i; j--){
                if(pre[j]-pre[i] > 0){
                    max = Math.max(max, j-1-i+1);
                    break;
                }
            }
        }
        return max;
    }
}
