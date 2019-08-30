package topics.Sort.l506RelativeRanks;
import java.util.Arrays;
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[][] aux = new int[len][2];
        for(int i = 0; i < len; ++i) {
            aux[i][0] = i;
            aux[i][1] = nums[i];
        }
        Arrays.sort(aux, (a, b) -> (b[1] - a[1]));
        String[] res = new String[len];

        for(int i = 0; i < len; ++i) {
            int index = aux[i][0];
            if(i == 0) res[index] = "Gold Medal";
            else if(i == 1) res[index] = "Silver Medal";
            else if(i == 2) res[index] = "Bronze Medal";
            else res[index] = Integer.toString(i + 1);
        }

        return res;
    }
}