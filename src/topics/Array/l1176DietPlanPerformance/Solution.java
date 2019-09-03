package topics.Array.l1176DietPlanPerformance;
// the underline question is just sliding windowgit
public class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int start = 0, end = 0;
        int cur = 0, len = calories.length;
        if(k > len) return points;
        for(; start < k; ++start) {
            cur += calories[start];
        }
        if(cur < lower) points--;
        if(cur > upper) points++;
        while(start < len) {
            cur -= calories[end++];
            cur += calories[start++];
            if(cur < lower) points--;
            if(cur > upper) points++;
        }

        return points;
    }
}